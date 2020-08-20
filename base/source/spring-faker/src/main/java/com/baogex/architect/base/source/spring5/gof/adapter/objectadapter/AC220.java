package com.baogex.architect.base.source.spring5.gof.adapter.objectadapter;

/**
 * <p>
 * 220V交流电
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public class AC220 {
    public int outPutAC220V() {
        int v220 = 220;
        System.out.println("输出电压：" + v220);
        return v220;
    }
}

