package com.funstar.feign.demo.feign.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * feign接口异常处理逻辑
 * method优先级高于type
 * @author hzwangyuantao
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FeignExHandle {

    FeignExHandleType handleType() default FeignExHandleType.THROW;

}
