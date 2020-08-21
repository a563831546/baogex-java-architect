package com.baogex.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-21
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BGAutowired {
    String value() default "";
}
