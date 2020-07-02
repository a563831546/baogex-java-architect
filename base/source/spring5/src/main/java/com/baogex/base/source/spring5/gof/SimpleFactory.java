package com.baogex.base.source.spring5.gof;

import com.baogex.base.source.spring5.gof.dto.IBook;
import com.baogex.base.source.spring5.gof.dto.JavaBook;
import com.baogex.base.source.spring5.gof.dto.PythonBook;

/**
 * <p>
 * 简单工厂模式
 * </p>
 *
 * @author : baogex
 * @date : 2020-07-01
 **/
public class SimpleFactory {
    public static void main(String[] args) throws Exception {
        BookFactory.createBook(JavaBook.class).readBook();
        BookFactory.createBook(PythonBook.class).readBook();
    }


    // ================================自定义类==========================================

    static class BookFactory {
        public static IBook createBook(Class<? extends IBook> clazz) throws Exception {
            if (clazz != null) {
                // baogex-remark:反射无参构造函数时，必须显式创建无参构造函数
                return clazz.getConstructor().newInstance();
            }
            return null;
        }
    }
}
