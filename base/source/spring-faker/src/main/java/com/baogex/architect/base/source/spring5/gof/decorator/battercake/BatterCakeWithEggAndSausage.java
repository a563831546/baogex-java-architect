package com.baogex.architect.base.source.spring5.gof.decorator.battercake;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public class BatterCakeWithEggAndSausage extends BatterCakeWithEgg {
    @Override
    protected String getMsg() {
        return super.getMsg() + "-加根肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }

    public static void main(String[] args) {
        BatterCakeWithEggAndSausage batterCake = new BatterCakeWithEggAndSausage();
        System.out.println("我买了:"+batterCake.getMsg());
        System.out.println("花费:"+batterCake.getPrice());
    }
}
