package com.baogex.architect.base.source.spring5.gof.factory.dto;

/**
 * <p>
 * java学习资源
 * </p>
 *
 * @author : baogex
 * @date : 2020-07-03
 **/
public class JavaStudyMode implements StudyMode {
    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }

    @Override
    public IBook createBook() {
        return new JavaBook();
    }
}
