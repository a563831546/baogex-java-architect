package com.baogex.architect.base.source.spring5.gof.singleton;

/**
 * <p>
 * 注册式单例模式
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-08
 */
public enum EnumSingleton {
    /**
     * 唯一实例
     */
    INSTANCE;
    private Object Data;

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
