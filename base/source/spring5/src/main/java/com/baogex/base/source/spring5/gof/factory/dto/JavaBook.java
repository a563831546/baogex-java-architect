package com.baogex.base.source.spring5.gof.factory.dto;

/**
 * <p>
 *
 * </p>
 *
 * @author : baogex
 * @date : 2020-07-01
 **/
public class JavaBook implements IBook {
    public JavaBook() {
    }

    @Override
    public void readBook() {
        System.out.println("开始读Java的书!");
    }
}
