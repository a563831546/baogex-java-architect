package com.baogex.architect.base.source.spring5.gof.proxy.dyn;

import com.baogex.architect.base.source.spring5.gof.proxy.sta.simple.Person;
import com.baogex.architect.base.source.spring5.gof.proxy.sta.simple.Son;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public class BGMeipo implements BGInvocationHandler {
    private Object target;

    public Object getInstance(Object obj) throws Exception{
        this.target=obj;
        Class<?>clazz = target.getClass();
        return BGProxy.newProxyInstance(new BGClassLoader(),clazz.getInterfaces(),this);
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] arg) throws Throwable {
        before();
        method.invoke(this.target, arg);
        after();
        return null;
    }

    private void before() {
        System.out.println("before===============");
    }

    private void after() {
        System.out.println("after===============");
    }

    public static void main(String[] args) throws Exception {
        Person person = (Person) new BGMeipo().getInstance(new Son());
        person.findLove();
    }
}
