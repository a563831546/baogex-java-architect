package com.baogex.architect.base.source.spring5.gof.strategy.promotion;

/**
 * <p>
 * 现金返现
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public class CashBackStrategy  implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("执行返现");
    }
}
