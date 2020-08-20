package com.baogex.architect.base.source.spring5.gof.strategy.pay.payport;

import com.baogex.architect.base.source.spring5.gof.strategy.pay.paystate.Payment;

/**
 * <p>
 * 支付宝
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public class Alipay extends Payment {

    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
