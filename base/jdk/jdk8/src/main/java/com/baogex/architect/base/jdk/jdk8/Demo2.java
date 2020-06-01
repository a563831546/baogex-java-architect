package com.baogex.architect.base.jdk.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: baogex
 * @Date: 2020/5/31
 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println("jdk8前排序\r");
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(names);
        names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println("jdk8-lambda:\r");
        System.out.println(names);
    }
}
