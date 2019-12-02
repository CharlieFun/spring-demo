package com.funstar.feign.demo.feign.base;

public enum FeignExHandleType {

    /** 捕获异常，自动返回 */
    AUTO_RETURN,

    /** 抛出异常 */
    THROW,

    /** 返回空 */
    RETURN_NULL,

}
