package com.baogex.architect.base.source.spring5.gof.strategy.pay.payport;

import com.baogex.architect.base.source.spring5.gof.strategy.pay.paystate.Payment;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 支付策略
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public class PayStrategy {
    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String DEFAULT_PAY = "AliPay";
    static Map<String, Payment> payStrategyManager = new HashMap<>(8);

    static {
        payStrategyManager.put(ALI_PAY, new Alipay());
        payStrategyManager.put(JD_PAY, new JDPay());
        payStrategyManager.put(UNION_PAY, new UnionPay());
        payStrategyManager.put(WECHAT_PAY, new WechatPay());
    }

    public static Payment getPayment(String payType) {
        return payStrategyManager.get(payType);
    }

}
