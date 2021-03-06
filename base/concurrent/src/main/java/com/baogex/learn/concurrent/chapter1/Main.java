package com.baogex.learn.concurrent.chapter1;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @Author: baogex
 * @Date: 2020/5/2
 */
public class Main { 
    public static void main(String[] args) {
        Thread threads[] = new Thread[10];
        Thread.State states[] = new Thread.State[10];
        System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);
        System.out.printf("Minimum Priority: %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        for (int i = 0; i < 10; i++) {
            // 偶数线程最高优先级，奇数最低
            threads[i] = new Thread(new Calculator());
            if (i % 2 == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread -" + i);
        }
        try (FileWriter file = new FileWriter("g:\\logs\\JavaArchitect\\log.txt");
             PrintWriter pw = new PrintWriter(file);) {
            // 启动线程
            for (int i = 0; i < 10; i++) {
                states[i] = threads[i].getState();
                pw.println("Main : Status of Thread -" + i + " : " + states[i]);
                threads[i].start();
            }
            boolean finish = false;
            while (!finish) {
                // 记录所有线程当前状态
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != states[i]) {
                        writeThreadInfo(pw, threads[i], states[i]);
                        states[i] = threads[i].getState();
                    }
                }
                finish = true;
                // 所有线程都关闭后为true
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() ==
                            Thread.State.TERMINATED);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 写入本地日志
     * @param pw
     * @param thread
     * @param state
     */
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(),
                thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }
}
