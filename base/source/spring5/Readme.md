#<Spring 5核心原理与30个类手写实战>
##软件架构设计原则

* 开闭原则(Open-Closed Principle=OCP)
对扩展开放,对修改关闭。

* 依赖倒置原则(Dependence Inversion Principle=DIP)
高层模块不应该依赖低层模块，应依赖其抽象，抽象不依赖细节,细节应依赖抽象。(以接口为参，实现为扩展)

* 单一职责（Simple Responsibility Pinciple,SRP)
一个类、 接口或方法只负责一项职责

* 接口隔离原则（Interface Segregation Principle,ISP)
 用多个专门接口代替单一的总接口，高内聚、 低耦合。

* 迪米特原则（Law of Demeter LoD)
开闭原则的延伸，只依赖应该依赖的对象，只暴露应该暴露的方法。

* 里氏替换原则（Liskov Substitution Principle,LSP)
子类可以扩展父类的功能,但不能改变父类原有的功能。

* 合成复用原则 (Composite/Aggregate Reuse Principle,CARP)
 尽量使用对象组合(has-a)/聚合而不是继承,降低修改类对其他类的影响.
 




