package com.baogex.architect.base.source.spring5.gof.factory.dto;

/**
 * <p>
 *
 * </p>
 *
 * @author : baogex
 * @date : 2020-07-01
 **/
public class PythonBook implements IBook {
    public PythonBook() {
    }

    @Override
    public void readBook() {
        System.out.println("开始读Python的书!");
    }
}
