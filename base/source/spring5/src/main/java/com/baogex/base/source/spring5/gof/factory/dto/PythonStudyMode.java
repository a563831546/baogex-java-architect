package com.baogex.base.source.spring5.gof.factory.dto;

/**
 * <p>
 * java学习资源
 * </p>
 *
 * @author : baogex
 * @date : 2020-07-03
 **/
public class PythonStudyMode implements StudyMode {
    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }

    @Override
    public IBook createBook() {
        return new PythonBook();
    }
}
