package com.baogex.base.source.spring5.gof.factory;

import com.baogex.base.source.spring5.gof.factory.dto.JavaStudyMode;
import com.baogex.base.source.spring5.gof.factory.dto.PythonStudyMode;

/**
 * <p>
 * 抽象工厂模式
 * </p>
 *
 * @author : baogex
 * @date : 2020-07-03
 **/
public class AbstractFactory {
    public static void main(String[] args) {
        JavaStudyMode javaStudyMode = new JavaStudyMode();
        System.out.println("进入java学习模式");
        javaStudyMode.createBook().readBook();
        javaStudyMode.createVideo().Watch();
        PythonStudyMode pythonStudyMode = new PythonStudyMode();
        System.out.println("进入python学习模式");
        pythonStudyMode.createBook().readBook();
        pythonStudyMode.createVideo().Watch();

    }
}
