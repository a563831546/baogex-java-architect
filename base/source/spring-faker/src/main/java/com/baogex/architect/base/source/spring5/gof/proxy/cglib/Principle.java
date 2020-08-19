package com.baogex.architect.base.source.spring5.gof.proxy.cglib;

import com.baogex.architect.base.source.spring5.gof.proxy.sta.simple.Son;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * <p>
 * 原理探究
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-19
 */
public class Principle {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\data\\bg");
        Son son = (Son) new CglibMeipo().getInstance(Son.class);
        son.findLove();
    }
    
}
