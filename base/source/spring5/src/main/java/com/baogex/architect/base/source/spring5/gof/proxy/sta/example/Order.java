package com.baogex.architect.base.source.spring5.gof.proxy.sta.example;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-09
 */
public class Order {
    private String id;
    private Integer createTime;
    private Object OrderInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Object getOrderInfo() {
        return OrderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        OrderInfo = orderInfo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", createTime=" + createTime +
                ", OrderInfo=" + OrderInfo +
                '}';
    }
}
