package com.baogex.architect.base.source.spring5.gof.strategy.promotion;

/**
 * <p>
 * 拼团
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public class GroupbuyStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("执行拼团策略");
    }
}
