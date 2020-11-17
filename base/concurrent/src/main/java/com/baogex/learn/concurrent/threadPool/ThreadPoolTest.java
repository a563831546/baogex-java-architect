package com.baogex.learn.concurrent.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author: baogex
 * @Date: 2020/6/15
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
    }
}
