package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by tianxianglan on 2017/6/4.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SelfPermitition {

    PermissionEnum value() default PermissionEnum.COMMON_USER;


}
