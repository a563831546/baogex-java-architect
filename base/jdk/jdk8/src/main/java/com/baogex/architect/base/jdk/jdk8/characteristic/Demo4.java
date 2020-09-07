package com.baogex.architect.base.jdk.jdk8.characteristic;

import java.util.function.BiFunction;

/**
 * 四、方法与构造函数引用
 *
 * @Author: baogex
 * @Date: 2020/5/31
 */
public class Demo4 {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create1("Peter", "Parker");
        System.out.println(person);
    }

    static class Person {
        String firstName;
        String lastName;

        Person() {
        }

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    interface PersonFactory<P extends Person> {
        P create1(String firstName, String lastName);
    }

}
