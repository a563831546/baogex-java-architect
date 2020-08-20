package com.baogex.architect.base.source.spring5.gof.strategy.pay.payport;

import com.baogex.architect.base.source.spring5.gof.strategy.pay.paystate.Payment;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
