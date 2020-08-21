package com.baogex.architect.base.source.spring5.gof.observer.bgeradvice;

import lombok.Getter;

import java.util.Observable;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-21
 */

public class BGer extends Observable {
    @Getter
    private String name = "华农";
    private static BGer bGer = null;

    private BGer() {
    }

    // 单例
    public static BGer getInstance() {
        if (bGer == null) {
            bGer = new BGer();
        }
        return bGer;
    }

    public void publishQuestion(Question question) {
        System.out.println("吊毛:" + question.getName() + "在【" + this.getName() + "】这提问了很蠢的问题" + question.getContent());
        setChanged();
        notifyObservers(question);
    }
}
