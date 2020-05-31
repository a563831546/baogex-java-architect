package com.baogex.learn.concurrent.chapter1.interrupted;

import com.baogex.learn.concurrent.chapter1.Calculator;

/**
 * @Author: baogex
 * @Date: 2020/5/7
 */
public class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isInterrupted()) {
                System.out.println("the prime generator has been isInterrupted");
                return;
            }
            if (Calculator.isPrime(number)) {
                System.out.printf("number %d is prime\n", number);
            }

            number++;
        }
    }

}
