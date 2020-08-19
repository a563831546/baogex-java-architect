package com.baogex.architect.base.source.spring5.gof.proxy.dyn;

import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

public class $Proxy0 implements com.baogex.architect.base.source.spring5.gof.proxy.sta.simple.Person {
    BGInvocationHandler h;

    public $Proxy0(BGInvocationHandler h) {
        this.h = h;
    }

    @Override
    public void findLove() {
        try {
            Method m = com.baogex.architect.base.source.spring5.gof.proxy.sta.simple.Person.class.getMethod("findLove", new Class[]{});
            this.h.invoke(this, m, new Object[]{});
        } catch (Error _ex_) {
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}

