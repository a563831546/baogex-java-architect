package com.baogex.architect.base.jdk.jdk8.functional;



/**
 * <p>
 * 方法引用
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-25
 */
public class FuncReferences {
    static void hello(String name) {
        System.out.println("Hello, " + name);
    }
    static class Description {
        String about;

        Description(String desc) {
            about = desc;
        }

        void help(String msg) {
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static String  assist(String msg) {
            System.out.println(msg);
            return "asds";
        }
    }
    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show;
        c.call("call()");

        c = FuncReferences::hello;
        c.call("Bob");

        c = new Description("valuable")::help;
        c.call("information");

        c = Helper::assist;
        c.call("Help!");
    }
}
interface Callable { void call(String s);}
class Describe {
    void show(String msg) { System.out.println(msg); }
}
