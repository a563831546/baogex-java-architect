package com.baogex.architect.base.jdk.jdk8;

/**
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
        default int t(){
            return 1;
        }
    }

}
