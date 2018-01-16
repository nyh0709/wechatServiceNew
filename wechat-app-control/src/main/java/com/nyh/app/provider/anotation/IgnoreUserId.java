package com.nyh.app.provider.anotation;

import java.lang.annotation.*;

/**
 * 忽略userId校验
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreUserId {
}
