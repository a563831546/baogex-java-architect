package com.baogex.architect.base.source.spring5.gof.proxy.sta.simple;

/**
 * <p>
 * 儿子行为
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-09
 */
public class Son implements Person {
    @Override
    public void findLove() {
        System.out.println("儿子要求:要求大长腿");
    }
}
