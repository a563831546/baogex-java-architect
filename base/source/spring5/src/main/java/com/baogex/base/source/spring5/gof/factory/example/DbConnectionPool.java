package com.baogex.base.source.spring5.gof.factory.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
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


    /**
     * 连接字符串
     */
    private String url = null;
    /**
     * 用户名
     */
    private String userName = null;
    /**
     * 密码
     */
    private String passWord = null;


    /**
     * 空闲连接数
     */
    private static int freeNum = 0;
    /**
     * 可用连接数
     */
    private static int activeNum = 0;
    /**
     * 连接池实例变量
     */
    private static DbConnectionPool pool = null;


    /**
     * 获取数据库连接池的实例
     *
     * @return
     */
    public static synchronized DbConnectionPool getInstance() {
        if (pool == null) {
            pool = new DbConnectionPool();
        }
        return pool;
    }

    /**
     * 构造函数，初始话数据库连接池
     */
    private DbConnectionPool() {
        try {
            init();
            for (int i = 0; i < normalConnect; i++) {
                Connection connection = newConnection();
                if (connection != null) {
                    freeConnects.addElement(connection);
                    ++freeNum; //空闲连接数+1
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个连接
     *
     * @return
     */
    private Connection newConnection() {
        try {
            if (userName == null) {
                DriverManager.getConnection(url);
            } else {
                DriverManager.getConnection(url, userName, passWord);
            }
            System.out.println("成功一个连接");
        } catch (SQLException throwables) {
            System.out.println("获取连接失败");
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 初始化
     *
     * @throws IOException
     */
    private void init() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream(propertiesName));
        this.userName = properties.getProperty("username");
        this.passWord = properties.getProperty("passWord");
        this.url = properties.getProperty("url");
        this.driverName = properties.getProperty("driverName");
        this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
        this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
    }

    /**
     * 创建连接池
     */
    @Override
    public void createPool() {
        pool = new DbConnectionPool();
        if (pool != null) {
            System.out.println("创建连接池成功！");
        } else {
            System.out.println("创建连接池失败！");
        }
    }

    /**
     * 单例   获取一个可用连接
     *
     * @return
     */
    @Override
    public Connection getConnect() {
        Connection connection = null;
        if (freeConnects.size() > 0) {
            freeNum--;
            connection = freeConnects.firstElement();
            freeConnects.remove(0);
            try {
                if (connection.isClosed()) {
                    System.out.println("删除一个无效连接");
                    connection = getConnect();
                }
            } catch (SQLException throwables) {
                System.out.println("删除一个无效连接");
                connection = getConnect();
            }
        } else if (maxConnect == 0 || checkedOut < maxConnect) {
            connection = newConnection();
        }
        if (null != connection) {
            checkedOut++;
        }

        return connection;
    }

    /**
     * 获取一个连接，加上时间限制
     *
     * @param time
     * @return
     */
    @Override
    public Connection getConnect(long time) {
        Connection connection = null;
        long startTime = System.currentTimeMillis();
        while ((connection = getConnect()) == null) {
            try {
                wait(time);
            } catch (InterruptedException e) {
            }
            if ((System.currentTimeMillis() - startTime) >= time) {
                return null;
            }
        }
        return connection;
    }

    /**
     * 释放连接，连接放入连接池
     *
     * @param con
     * @return
     */
    @Override
    public void freeConnect(Connection con) {
        freeConnects.add(con);
        freeNum++;         // 空闲
        activeNum--;       // 可用
        checkedOut--;   // 当前线程池正在使用的连接数
        notifyAll();
    }

    @Override
    protected synchronized void release() {
        try {
            // 将所有连接放入枚举
            Enumeration<Connection> elements = freeConnects.elements();
            while (elements.hasMoreElements()) {
                Connection connection = elements.nextElement();
                try {
                    connection.close();
                    freeNum--;
                } catch (SQLException throwables) {
                    System.out.println("无法关闭该连接");
                }
            }
            freeConnects.removeAllElements();
            activeNum = 0;
        } finally {
            super.release();
        }
    }

    /**
     * 获取可用连接
     *
     * @return
     */
    @Override
    public int getFreeNum() {
        return freeNum;
    }

    /**
     * 获取当前连接数
     */
    @Override
    public int getActiveNum() {

        return activeNum;
    }
}
