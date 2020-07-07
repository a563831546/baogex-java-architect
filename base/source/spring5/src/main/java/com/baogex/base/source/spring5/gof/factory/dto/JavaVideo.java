package com.baogex.base.source.spring5.gof.factory.dto;

/**
 * <p>
 *
 * </p>
 *
 * @author : baogex
 * @date : 2020-07-03
 **/
public class JavaVideo implements IVideo {
    @Override
    public void Watch() {
        System.out.println("小心了，我开始看java视频了");
    }
}
