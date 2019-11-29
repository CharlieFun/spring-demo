package com.funstar.springdemo.feign.base;

import feign.Feign;
import feign.Request;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class FeignFactoryBean<T> implements FactoryBean, EnvironmentAware {


    private Environment environment;

    private Class<T> type;

    private String host;

    @Override
    public Object getObject() throws Exception {
        Object obj = Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .options(new Request.Options(3000, 5000))
                .target(this.type, parseServer(this.host));

        InvocationHandler invocationHandler = new FeignInvocationHandler(obj, this.type);

        return Proxy.newProxyInstance(this.type.getClassLoader(), new Class<?>[]{this.type}, invocationHandler);
    }

    private String parseServer(String host) {
        String hostVal = this.environment.resolvePlaceholders(this.host);
        if (StringUtils.isBlank(this.host) || StringUtils.isBlank(hostVal) || this.host.equals(hostVal)) {
            throw new RuntimeException("parse host failed, host: " + this.host + " hostVal:" + hostVal);
        }
        return hostVal;
    }

    @Override
    public Class<T> getObjectType() {
        return this.type;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
