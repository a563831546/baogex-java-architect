package com.baogex.architect.base.source.spring5.gof.proxy.sta.example;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-09
 */
public class IOrderServiceImpl implements IOrderService {
    private OrderDao orderDao;

    public IOrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public int createOrder(Order order) {
        return 0;
    }
}
