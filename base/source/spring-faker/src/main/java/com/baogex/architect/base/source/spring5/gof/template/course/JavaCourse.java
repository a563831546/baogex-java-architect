package com.baogex.architect.base.source.spring5.gof.template.course;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public class JavaCourse extends NetworkCourse {
    @Override
    void work() {
        System.out.println("java work");
    }

    @Override
    protected boolean needWork() {
        return true;
    }

    public static void main(String[] args) {
        new JavaCourse().createCourse();
    }
}
