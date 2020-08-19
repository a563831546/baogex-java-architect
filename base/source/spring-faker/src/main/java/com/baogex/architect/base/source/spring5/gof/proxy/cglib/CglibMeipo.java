package com.baogex.architect.base.source.spring5.gof.proxy.cglib;


import com.baogex.architect.base.source.spring5.gof.proxy.sta.simple.Son;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public class CglibMeipo implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("这是before//");
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        System.out.println("这是after//");
        return invokeSuper;
    }

    public static void main(String[] args) {
        Son son = (Son) new CglibMeipo().getInstance(Son.class);
        son.findLove();
    }
}
