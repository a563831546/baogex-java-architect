package com.baogex.architect.base.source.spring5.gof.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 促销策略工厂
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public class PromotionStrategyFactory {
    private static Map<String, PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.CASHBACK, new CouponStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.GROUPBY, new CouponStrategy());
    }

    private static final PromotionStrategy NON_PROMOTION = new EmptyStrategy();

    public PromotionStrategyFactory() {
    }

    public PromotionStrategy getPromotionStrategy(String promotion) {
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotion);
        return promotionStrategy == null ? NON_PROMOTION : promotionStrategy;
    }
}
