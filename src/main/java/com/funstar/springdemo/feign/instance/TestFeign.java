package com.funstar.springdemo.feign.instance;

import com.funstar.springdemo.feign.base.MyFeign;
import com.funstar.springdemo.model.User;
import feign.Param;
import feign.RequestLine;

@MyFeign(host = "${local.host}")
public interface TestFeign {

    @RequestLine("GET /feign/string")
    String string();

    @RequestLine("GET /feign/json")
    User json();

    @RequestLine("GET /feign/user?name={name}")
    User user(@Param("name") String name);

}
