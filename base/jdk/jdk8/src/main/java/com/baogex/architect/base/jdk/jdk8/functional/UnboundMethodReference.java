package com.baogex.architect.base.jdk.jdk8.functional;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-25
 */

// 没有方法引用的对象

class X {
    String f(String s) {
        return "X::f()" + s;
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x, String s);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
        // MakeString ms = X::f; // [1]
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x, "哈哈")); // [2]
        System.out.println(x.f("嘿嘿")); // 同等效果
    }
}