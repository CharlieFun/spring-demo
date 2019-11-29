package com.funstar.springdemo.spring;

import com.funstar.springdemo.service.impl.Cat;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Service
public class CatFactoryBean implements FactoryBean<Cat> {

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Cat getObject() throws Exception {
        return new Cat("New Tom");
    }

    @Override
    public Class<?> getObjectType() {
        return Cat.class;
    }
}
