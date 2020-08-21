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
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BGController {
    String value() default "";
}
