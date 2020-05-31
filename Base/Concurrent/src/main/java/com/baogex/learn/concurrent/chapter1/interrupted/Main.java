package com.baogex.learn.concurrent.chapter1.interrupted;

/**
 * @Author: baogex
 * @Date: 2020/5/7
 */
public class Main {
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep over");
        task.interrupt();
        System.out.println("interrupt over");
        System.out.printf("Main: Status of the Thread: %s\n", task.getState());
        System.out.printf("Main: isInterrupted: %s\n", task.isInterrupted());
        System.out.printf("Main: isAlive: %s\n", task.isAlive());
    }
}
