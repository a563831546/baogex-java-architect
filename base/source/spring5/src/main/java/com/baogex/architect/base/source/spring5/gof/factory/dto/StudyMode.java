package com.baogex.architect.base.source.spring5.gof.factory.dto;

/**
 * <p>
 * 开启学习模式
 * </p>
 *
 * @author : baogex
 * @date : 2020-07-03
 **/
public interface StudyMode {
    /**
     * 看视频
     * @return
     */
    IVideo createVideo();

    /**
     * 看书学习
     * @return
     */
    IBook createBook();
}
