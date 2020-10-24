package com.oycbest.springbootvalidated.limit;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author oyc
 * @Date 2020/10/22 11:16 下午
 */
@Inherited
@Documented
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {

    /**
     * 指定second 时间内 API请求次数
     */
    int maxCount() default 5;

    /**
     * 请求次数的指定时间范围  秒数(redis数据过期时间)
     */
    int second() default 60;
}