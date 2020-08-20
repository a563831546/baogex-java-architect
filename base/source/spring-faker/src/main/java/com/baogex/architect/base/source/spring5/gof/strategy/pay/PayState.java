package com.baogex.architect.base.source.spring5.gof.strategy.pay;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public class PayState {
    private int code;
    private Object data;
    private String msg;

    public PayState(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "支付状态:[" + code +
                "]," + msg +
                ",交易详情:" + data;
    }
}
