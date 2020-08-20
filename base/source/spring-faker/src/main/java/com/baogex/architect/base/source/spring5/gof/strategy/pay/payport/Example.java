package com.baogex.architect.base.source.spring5.gof.strategy.pay.payport;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public class Example {
    public static void main(String[] args) {
        Order order = new Order("1", "DES-5125123124", 30);
        /*
         * ............................
         */
        System.out.println(order.pay(PayStrategy.JD_PAY));
    }
}
