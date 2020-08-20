package com.baogex.architect.base.source.spring5.gof.strategy.promotion;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("执行优惠卷促销活动");
    }
}
