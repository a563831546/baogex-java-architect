package com.baogex.architect.base.source.spring5.gof.strategy.promotion;

/**
 * <p>
 * 促销策略
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public interface PromotionStrategy {
    /**
     * 执行促销
     */
    void doPromotion();
}
