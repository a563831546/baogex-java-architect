package com.baogex.architect.base.source.spring5.gof.strategy.promotion;

/**
 * <p>
 * 无促销
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public class EmptyStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("无促销");
    }
}
