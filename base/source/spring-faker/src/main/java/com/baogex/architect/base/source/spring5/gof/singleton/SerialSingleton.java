package com.baogex.architect.base.source.spring5.gof.singleton;

import java.io.*;

/**
 * <p>
 * 序列化破坏单例
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-07-08
 */
public class SerialSingleton implements Serializable {
    private static SerialSingleton INSTANCE = new SerialSingleton();

    private SerialSingleton() {

    }

    public static SerialSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 重要，添加readResolve()方法，读取对象的时候
     * java.io.ObjectInputStream#readObject() 源码中会调用重写的
     * 保证了序列化的时候数据一致性
     *
     * @return
     */
    private Object readResolve() {
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        SerialSingleton o1 = null;
        SerialSingleton o2 = getInstance();
        System.out.println(o1);
        System.out.println(o2);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("f://test.obj"));
        objectOutputStream.writeObject(o2);
        objectOutputStream.flush();
        objectOutputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("f://test.obj"));
        o1 = (SerialSingleton) inputStream.readObject();
        inputStream.close();
        System.out.println(o1);
        System.out.println(o2);
    }
}
