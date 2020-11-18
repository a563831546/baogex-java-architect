package com.baogex.java.architect.source.spring.core.ioc.model.chapter3;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-11-13
 */
@Data
public class ProductModel {
	private static int val = 0;
	private String name;

	public ProductModel() {
		this.name = ProductModel.class.getSimpleName() + "#" + (val++);
	}
}
