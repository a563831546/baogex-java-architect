package com.baogex.java.architect.source.spring.core.ioc.chapter2;

import com.baogex.java.architect.source.spring.core.ioc.model.chapter2.ControllerModel;
import com.baogex.java.architect.source.spring.core.ioc.model.chapter2.ServiceModel;
import com.baogex.java.architect.source.spring.core.ioc.model.chapter3.ProductModel;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-11-16
 */
public class Chapter2ApplicationStarter {
	public static void main(String[] args) {
		System.out.println(new ProductModel().getName());
		//GenericApplicationContext context = new GenericApplicationContext();
		//testXmlBeanDefinitionReader(context);
	}

	/**
	 * 配合使用读取器委托 GenericApplicationContext 非常的灵活,
	 * 例如使用XmlBeanDefinitionReader 读取xml文件,加载容器后手动调用refresh刷新容器实例化bean
	 *
	 * @see XmlBeanDefinitionReader
	 */
	private static void testXmlBeanDefinitionReader(GenericApplicationContext context ) {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);
		xmlBeanDefinitionReader.loadBeanDefinitions("classpath:config/core/ioc/chapter2/main-config.xml");
		xmlBeanDefinitionReader.loadBeanDefinitions("classpath:config/core/ioc/chapter2/service.xml");
		context.refresh();
		System.out.println(context.getBean(ControllerModel.class).getName());
		System.out.println(context.getBean(ServiceModel.class).getName());
	}
}
