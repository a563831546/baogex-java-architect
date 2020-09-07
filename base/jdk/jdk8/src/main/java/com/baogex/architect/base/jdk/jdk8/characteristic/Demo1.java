package com.baogex.architect.base.jdk.jdk8.characteristic;

/**
 * 一、接口的默认方法
 * <p>
 * Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法
 * </p>
 *
 * @Author: baogex
 * @Date: 2020/5/31
 */
public class Demo1 {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
        System.out.println(formula.t());
    }

    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(a);
        }

        default int t() {
            return 1;
        }
    }

}
