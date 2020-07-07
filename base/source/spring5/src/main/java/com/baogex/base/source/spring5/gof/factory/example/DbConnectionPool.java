package com.baogex.base.source.spring5.gof.factory.example;

import java.sql.Connection;
import java.util.Vector;

/**
 * <p>
 * 数据库连接池管理类
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-07
 */
public class DbConnectionPool extends Pool {
    /**
     * 正在使用的连接数
     */
    private int checkedOut;
    /**
     * 存放产生的连接对象容器
     */
    private Vector<Connection> freeConnects = new Vector<Connection>();

    @Override
    public void createPool() {

    }

    @Override
    public Connection getConnect() {
        return null;
    }

    @Override
    public Connection getConnect(long time) {
        return null;
    }

    @Override
    public Connection freeConnect(Connection con) {
        return null;
    }

    @Override
    public int getFreeNum() {
        return 0;
    }

    @Override
    public int getActiveNum() {
        return 0;
    }
}
