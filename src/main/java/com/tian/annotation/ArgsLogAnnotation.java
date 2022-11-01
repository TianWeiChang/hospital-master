package com.tian.annotation;

import java.lang.annotation.*;

/**
 * @author tianwc 公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月01日 17:20
 * <p>
 * 自定义注解
 * <p>
 * 用于方法出入参打印
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ArgsLogAnnotation {
    //方法描述
    String methodDescription() default "";
}
