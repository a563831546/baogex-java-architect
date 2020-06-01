package com.baogex.architect.base.jdk.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
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
         * @param from
         * @return
         */
       default T convert2(F from){
           return null;
       };
    }
}
