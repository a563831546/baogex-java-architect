package com.baogex.base.source.spring5.gof.factory.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * <p>
 * 自定义连接池
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-06
 */
public abstract class Pool {
    /**
     * 配置文件位置
     */
    public String propertiesName = "/connection-INF.properties";
    /**
     * 唯一实例
     */
    private static Pool instance = null;
    /**
     * 最大连接数
     */
    protected int maxConnect = 100;
    /**
     * 保持连接数
     */
    protected int normalConnect = 10;
    /**
     * 驱动字符串
     */
    protected String driverName = null;
    /**
     * 驱动别两
     */
    protected Driver driver = null;

    protected Pool() {
        try {
            init();
            loadDrivers(driverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始话参数
     *
     * @throws IOException
     */
    private void init() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream(propertiesName));
        this.driverName = properties.getProperty("driverName");
        maxConnect = Integer.parseInt((properties.getProperty("maxConnect")));
        normalConnect = Integer.parseInt((properties.getProperty("normalConnect")));
    }

    /**
     * 加载jdbc驱动
     *
     * @param driverName
     */
    private void loadDrivers(String driverName) {
        try {
            Driver driver = ((Driver) Class.forName(driverName).newInstance());
            DriverManager.registerDriver(driver);
            System.out.println("驱动加载成功:" + driverName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("驱动加载错误:" + driverName);
        }
    }

    /**
     * 创建连接池
     */
    public abstract void createPool();

    public static synchronized Pool getInstance() throws Exception {
        if (instance == null) {
            instance = (Pool) Class.forName("com.baogex.base.source.spring5.gof.factory.example.Pool").getDeclaredConstructor().newInstance();
        }
        return instance;
    }

    /**
     * 获取连接一个可用连接，如果没有则创建，小于最大连接限制
     *
     * @return
     */
    public abstract Connection getConnect();

    /**
     * 有时间限制创建一个可用连接
     *
     * @return
     */
    public abstract Connection getConnect(long time);

    /**
     * 释放一个连接返回给连接池
     *
     * @return
     */
    public abstract void freeConnect(Connection con);

    /**
     * 获取当前空闲连接数
     *
     * @return
     */
    public abstract int getFreeNum();

    /**
     * 获取当前工作连接数
     *
     * @return
     */
    public abstract int getActiveNum();

    /**
     * 释放连接
     */
    protected synchronized void release() {
        try {
            DriverManager.deregisterDriver(driver);
            System.out.println("成功-注销jdbc驱动程序:" + driver.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("失败-注销jdbc驱动程序:" + driver.getClass().getSimpleName());
        }
    }


    @Override
    public String toString() {
        return "Pool{" +
                "propertiesName='" + propertiesName + '\'' +
                ", maxConnect=" + maxConnect +
                ", normalConnect=" + normalConnect +
                ", driverName='" + driverName + '\'' +
                ", driver=" + driver +
                '}';
    }

    public static void main(String[] args) throws Exception {
        Pool instance = getInstance();
        System.out.println(instance.toString());
    }
}
