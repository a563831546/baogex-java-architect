package com.baogex.architect.base.source.spring5.gof.proxy.dyn;

import java.lang.reflect.Method;

/**
 * <p>
 * baogex静态代理
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-29
 */
public interface BGInvocationHandler {
    /**
     * 代理执行方法
     *
     * @param proxy  代理对象
     * @param method 执行函数
     * @param arg    参数
     * @return s
     * @throws Throwable s
     */
    Object invoke(Object proxy, Method method, Object[] arg) throws Throwable;

}
