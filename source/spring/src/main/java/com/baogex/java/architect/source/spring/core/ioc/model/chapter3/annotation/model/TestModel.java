package com.baogex.java.architect.source.spring.core.ioc.model.chapter3.annotation.model;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-11-16
 */
@Component
public class TestModel implements BeanNameAware {
	private String beanName;

	public String info() {
		return this.beanName;
	}


	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Override
	public String toString() {
		return info();
	}
}
