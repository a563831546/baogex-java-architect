package com.baogex.architect.base.jdk.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 三、函数式接口
 * <p>
 * 我们可以将lambda表达式当作任意只包含一个抽象方法的接口类型，确保你的接口一定达到这个要求，
 * 你只需要给你的接口添加 @FunctionalInterface 注解，
 * 编译器如果发现你标注了这个注解的接口有多于一个抽象方法的时候会报错的。
 * <p>
 * 作者：一入码坑深似海
 * 链接：https://www.jianshu.com/p/0bf8fe0f153b
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @Author: baogex
 * @Date: 2020/5/31
 */
public class Demo3 {
    public static void main(String[] args) {

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);
    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);

        /**
         * 只能有一个抽象方法，必须有默认实现
         *
         * @param from
         * @return
         */
        default T convert2(F from) {
            return null;
        }

        ;
    }
}
