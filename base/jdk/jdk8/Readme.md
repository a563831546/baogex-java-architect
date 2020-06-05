## JAVA8十大新特性详解（精编）
原文 [点击至](https://www.jianshu.com/p/0bf8fe0f153b)
### 接口的默认方法
Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法，示例如下：
```
interface Formula {
    double calculate(int a);
    default double sqrt(int a) {
        return Math.sqrt(a);
    }}
```
Formula接口在拥有calculate方法之外同时还定义了sqrt方法，实现了Formula接口的子类只需要实现一个calculate方法，默认方法sqrt将在子类上可以直接使用。

```java
Formula formula = new Formula() {
    @Override
    public double calculate(int a) {
        return sqrt(a * 100);
    }
};
formula.calculate(100);     // 100.0
formula.sqrt(16);           // 4.0
```
文中的formula被实现为一个匿名类的实例，该代码非常容易理解，6行代码实现了计算 sqrt(a * 100)。在下一节中，我们将会看到实现单方法接口的更简单的做法。

译者注： 在Java中只有单继承，如果要让一个类赋予新的特性，通常是使用接口来实现，在C++中支持多继承，允许一个子类同时具有多个父类的接口与功能，在其他语言中，
让一个类同时具有其他的可复用代码的方法叫做mixin。新的Java 8 的这个特新在编译器实现的角度上来说更加接近Scala的trait。 在C#中也有名为扩展方法的概念，
允许给已存在的类型扩展方法，和Java 8的这个在语义上有差别。

**思考:可有可无，但有些情况可以避免频繁的实现一些必要但冗余的代码，当项目规模较大的时候可以使代码更加简洁**

### Lambda 表达式
首先看看在老版本的Java中是如何排列字符串的：
```java
List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
});
```
只需要给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列。通常做法都是创建一个匿名的比较器对象然后将其传递给sort方法。

在Java 8 中你就没必要使用这种传统的匿名对象的方式了，Java 8提供了更简洁的语法，lambda表达式：
```java
Collections.sort(names, (String a, String b) -> {
    return b.compareTo(a);
});
```
看到了吧，代码变得更段且更具有可读性，但是实际上还可以写得更短：
```java
Collections.sort(names, (String a, String b) -> b.compareTo(a));
```
对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字，但是你还可以写得更短点：
```java
Collections.sort(names, (a, b) -> b.compareTo(a));
```
Java编译器可以自动推导出参数类型，所以你可以不用再写一次类型。接下来我们看看lambda表达式还能作出什么更方便的东西来
**java8神器，是java迈向函数式编程的重要一步**
### 函数式接口
Lambda表达式是如何在java的类型系统中表示的呢？每一个lambda表达式都对应一个类型，通常是接口类型。
而“函数式接口”是指仅仅只包含一个抽象方法的接口，每一个该类型的lambda表达式都会被匹配到这个抽象方法。
因为 默认方法 不算抽象方法，所以你也可以给你的函数式接口添加默认方法。
```java
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
Integer converted = converter.convert("123");
System.out.println(converted);    // 123
```
我们可以将lambda表达式当作任意只包含一个抽象方法的接口类型，确保你的接口一定达到这个要求，
你只需要给你的接口添加 @FunctionalInterface 注解，编译器如果发现你标注了这个注解的接口有多于一个抽象方法的时候会报错的

**思考**：为什么只能只包含一个抽象，因为()->{}，相当于匿名类只需要实现那个抽象就行了，符合类的敌营 

### 方法与构造函数引用
前一节中的代码还可以通过静态方法引用来表示：
```java
Converter<String, Integer> converter = Integer::valueOf;
Integer converted = converter.convert("123");
System.out.println(converted);   // 123
```
Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用，上面的代码展示了如何引用一个静态方法，我们也可以引用一个对象的方法：
```java
 converter = something::startsWith;
String converted = converter.convert("Java");
System.out.println(converted);    // "J"
```
接下来看看构造函数是如何使用::关键字来引用的，首先我们定义一个包含多个构造函数的简单类：
```java
class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
```
接下来我们指定一个用来创建Person对象的对象工厂接口：
```java
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
```
这里我们使用构造函数引用来将他们关联起来，而不是实现一个完整的工厂：
```java
PersonFactory<Person> personFactory = Person::new;
Person person = personFactory.create("Peter", "Parker");
```
我们只需要使用 Person::new 来获取Person类构造函数的引用，Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数。

**思考**：当传入一个方法引用时候，编译器自动匹配唯一的抽象方法

### 五、Lambda 作用域
在lambda表达式中访问外层作用域和老版本的匿名对象中的方式很相似。你可以直接访问标记了final的外层局部变量，或者实例的字段以及静态变量。

### 六、访问局部变量
我们可以直接在lambda表达式中访问外层的局部变量：

```java
final int num = 1;
Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);

stringConverter.convert(2);     // 3
```
但是和匿名对象不同的是，这里的变量num可以不用声明为final，该代码同样正确：
   
```java
int num = 1;
Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);

stringConverter.convert(2);     // 3

```

不过这里的num必须不可被后面的代码修改（即隐性的具有final的语义），例如下面的就无法编译：

```java
int num = 1;
Converter<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);
num = 3;
```
在lambda表达式中试图修改num同样是不允许的。

**思考** 进入lambda表达式的外部变量都会被修饰为final