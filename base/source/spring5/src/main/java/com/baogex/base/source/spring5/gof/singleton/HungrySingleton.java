package com.baogex.base.source.spring5.gof.singleton;

/**
 * <p>
 * 饿汉模式
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-08
 */
public class HungrySingleton  {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
