package com.baogex.architect.base.source.spring5.gof.strategy.promotion;

/**
 * <p>
 * 促销方案类
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void execute() {
        promotionStrategy.doPromotion();
    }

    public static void main(String[] args) {
        PromotionActivity promotionActivity = new PromotionActivity(new CashBackStrategy());
        PromotionActivity groupPromotion = new PromotionActivity(new GroupbuyStrategy());
        promotionActivity.execute();
        groupPromotion.execute();
    }
}
