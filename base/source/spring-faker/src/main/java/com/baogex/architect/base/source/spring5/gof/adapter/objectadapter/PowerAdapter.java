package com.baogex.architect.base.source.spring5.gof.adapter.objectadapter;

/**
 * <p>
 * 电源适配器
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public class PowerAdapter implements DC5 {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outPutDC5V() {
        int in = ac220.outPutAC220V();
        // 具体选择变压逻辑，可使用策略模式
        int outPut = in / 44;
        System.out.println("输出电压：" + outPut);
        return outPut;
    }

    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        System.out.println(dc5.outPutDC5V());
    }
}
