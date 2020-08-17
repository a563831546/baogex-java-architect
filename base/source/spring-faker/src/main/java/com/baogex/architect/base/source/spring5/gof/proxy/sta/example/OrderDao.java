package com.baogex.architect.base.source.spring5.gof.proxy.sta.example;

/**
 * <p>
 * 订单数据库操作dao
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-09
 */
public class OrderDao {
    public int insert(Order order){
        System.out.println("成功插入一条记录,"+order);
        return 1;
    }
}
