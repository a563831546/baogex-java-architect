package com.baogex.architect.base.source.spring5.gof.decorator.battercake;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public class BatterCakeWithEgg extends BatterCake {
    @Override
    protected String getMsg() {
        return super.getMsg() + "加个蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
