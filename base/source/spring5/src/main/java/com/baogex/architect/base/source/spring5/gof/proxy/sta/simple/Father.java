package com.baogex.architect.base.source.spring5.gof.proxy.sta.simple;

/**
 * <p>
 * 我儿子他爹
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-09
 */
public class Father {
    private Son son;

    public Father(Son son) {
        this.son = son;
    }
    
    public void findLove(){
        System.out.println("我他爹:帮儿子物色物色");
        this.son.findLove();
        System.out.println("儿子条件太差，找不到!");
    }

    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLove();
    }
}
