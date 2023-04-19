package com.master.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * AccessLimit
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 15:04
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLimit {
    int seconds();

    int maxCount();

    boolean needLogin() default true;
}
