package com.baogex.architect.base.source.spring5.gof.observer.bgeradvice;

import lombok.AllArgsConstructor;

import java.util.Observable;
import java.util.Observer;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-21
 */
@AllArgsConstructor
public class TeacherAndTest implements Observer {
    private String name;


    @Override
    public void update(Observable observable, Object o) {
        if (!(observable instanceof BGer)) {
            throw new IllegalArgumentException("你tm是个啥玩意就订阅");
        }
        if (!(o instanceof Question)) {
            throw new IllegalArgumentException("真是连问题都算不上:" + o.getClass().getTypeName());
        }
        BGer bGer = (BGer) observable;
        Question question = (Question) o;
        System.out.println("您订阅的："+bGer.getName() + ",有个吊毛[" + question.getName() +
                "]提了个问题：" + question.getContent() + ",我是" + name + ",我现在很慌!");
    }

    public static void main(String[] args) {
        BGer bGer = BGer.getInstance();
        bGer.addObserver(new TeacherAndTest("小猪"));
        bGer.addObserver(new TeacherAndTest("狗"));
        Question question = new Question("大聪明", "空腹能不能吃饭?");
        bGer.publishQuestion(question);
    }
}
