package com.baogex.architect.base.source.spring5.gof.strategy.pay.payport;

import com.baogex.architect.base.source.spring5.gof.strategy.pay.PayState;
import com.baogex.architect.base.source.spring5.gof.strategy.pay.paystate.Payment;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay() {
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public PayState pay(String payType) {
        Payment payment = PayStrategy.getPayment(payType);
        System.out.println("您用:" + payment.getName());
        System.out.println("花费:" + amount + ",准备扣款");
        return payment.pay(uid, amount);
    }

}
