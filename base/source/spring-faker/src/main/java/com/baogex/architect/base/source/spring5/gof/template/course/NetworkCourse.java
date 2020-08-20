package com.baogex.architect.base.source.spring5.gof.template.course;

/**
 * <p>
 * 网课模板
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-20
 */
public abstract class NetworkCourse {

    public void createCourse() {
        // 发布预习资料
        this.preview();
        // 制作ppt
        this.ppt();
        // 录制视频
        this.video();
        // 上传课程资料
        this.upload();
        // 是否布置作业
        if (needWork()) {
            work();
        }
    }

    protected boolean needWork() {
        return false;
    }

    abstract void work();

    final void upload() {
        System.out.println("上传课程资料");
    }

    final void video() {
        System.out.println("录制视频");
    }

    final void ppt() {
        System.out.println("制作ppt");
    }

    final void preview() {
        System.out.println("发布预习资料");
    }

}
