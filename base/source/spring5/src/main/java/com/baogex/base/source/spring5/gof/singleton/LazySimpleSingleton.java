package com.baogex.base.source.spring5.gof.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <p>
 * 懒汉模式
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-08
 */
public class LazySimpleSingleton {
    public static LazySimpleSingleton instance;

    private LazySimpleSingleton() {
        if (InnerSingleton.LAZY != null) {
            throw new RuntimeException("不能创建多个实例");
        }
    }

    /**
     * 双重锁模式，虽然线程安全了，但使用了同步锁多少有点性能缺失
     *
     * @return
     */
    public static LazySimpleSingleton getInstance() {
        if (instance == null) {
            synchronized (LazySimpleSingleton.class) {
                if (instance == null) {
                    instance = new LazySimpleSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类只有该类被使用时候后才会初始化，完美解决了安全与内存占用问题
     *
     * @return
     */
    public static final LazySimpleSingleton getInstanceByInner() {
        return InnerSingleton.LAZY;
    }

    private static class InnerSingleton {
        private static final LazySimpleSingleton LAZY = new LazySimpleSingleton();
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<LazySimpleSingleton> aClass = LazySimpleSingleton.class;
        Constructor<LazySimpleSingleton> constructor = aClass.getDeclaredConstructor(null);
         constructor.setAccessible(true);
        LazySimpleSingleton lazySimpleSingleton = constructor.newInstance();
        System.out.println(LazySimpleSingleton.getInstanceByInner());
        System.out.println(LazySimpleSingleton.getInstanceByInner());
        System.out.println(LazySimpleSingleton.getInstanceByInner());

    }
}
