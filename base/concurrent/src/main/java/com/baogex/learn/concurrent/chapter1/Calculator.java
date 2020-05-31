package com.baogex.learn.concurrent.chapter1;

/**
 * 本节将在一个案例中创建10个线程来找出20000以内的质数
 *
 * @Author: baogex
 * @Date: 2020/5/2
 */
public class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 1L;
        long max = 20000L;
        long numPrimes = 0L;
        System.out.printf("thread '%s':start\n", Thread.currentThread().getName());
        while (current < max) {
            if (isPrime(current)) {
                numPrimes++;
            }
            current++;
        }
        System.out.printf(" thread '%s' :end. number of primes : %d\n",
                Thread.currentThread().getName(), numPrimes);
    }

    /**
     * 判断是否为质数
     */
    public static boolean isPrime(long current) {
        if (current <= 2) {
            return true;
        }
        for (long i = 2; i < current; i++) {
            if ((current % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
