package com.baogex.base.source.spring5.gof;

import com.baogex.base.source.spring5.gof.dto.IBook;
import com.baogex.base.source.spring5.gof.dto.JavaBook;
import com.baogex.base.source.spring5.gof.dto.PythonBook;

/**
 * <p>
 * 工厂类集中了所有实例（产品）的创建逻辑，一旦这个工厂不能正常工作，整个系统都会受到影响；
 * 违背“开放 - 关闭原则”，一旦添加新产品就不得不修改工厂类的逻辑，这样就会造成工厂逻辑过于复杂。
 * 简单工厂模式由于使用了静态工厂方法，静态方法不能被继承和重写，会造成工厂角色无法形成基于继承的等级结构。
 *     
 * 工厂方法模式，又称工厂模式、多态工厂模式和虚拟构造器模式，通过定义工厂父类负责定义创建对象的公共接口，而子类则负责生成具体的对象。
 * 
 * </p>
 *
 * @author : baogex
 * @date : 2020-07-01
 **/
public class FunctionFactory {
    public static void main(String[] args) {
        IBookFactory factory = new JavaBookFactory();
        factory.create().readBook();
        factory = new PythonBookFactory();
        factory.create().readBook();
    }

    // ================================自定义类==========================================

    interface IBookFactory {
        /**
         * @return 书籍对象
         */
        IBook create();
    }

    public static class JavaBookFactory implements IBookFactory {

        @Override
        public IBook create() {
            return new JavaBook();
        }
    }

    public static class PythonBookFactory implements IBookFactory {

        @Override
        public IBook create() {
            return new PythonBook();
        }
    }
}
