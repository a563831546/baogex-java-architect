package com.baogex.java.architect.source.spring.core.ioc.chapter3;

import com.baogex.java.architect.source.spring.core.ioc.model.chapter3.ProductModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-11-16
 */
public class Chapter3ApplicationStarter {

	public static void main(String[] args) {
		// 主容器
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:config/core/ioc/chapter3/main-config.xml");
		// 测试容器生成默认beanName规则
		testIoCContainerDefautlName(app);
	}

	/**
	 * 如果没有设值容器会生成一个唯一name给bean 容器
	 * 默认在权限类名后面添加#加阿拉伯数字，一次递增
	 */
	private static void testIoCContainerDefautlName(ApplicationContext app) {
		System.out.println(app.getBean("com.baogex.java.architect.source.spring.core.ioc.model.chapter3.ProductModel#0"));
		System.out.println(app.getBean("com.baogex.java.architect.source.spring.core.ioc.model.chapter3.ProductModel#1"));
		System.out.println(app.getBean("com.baogex.java.architect.source.spring.core.ioc.model.chapter3.ProductModel#2"));
		System.out.println(app.getBean("com.baogex.java.architect.source.spring.core.ioc.model.chapter3.ProductModel#3"));
	}
}
