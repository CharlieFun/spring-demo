package com.funstar.feign.demo.rest;

import com.funstar.feign.demo.feign.instance.TestFeign;
import com.funstar.feign.demo.model.User;
import com.funstar.feign.demo.service.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Animal animal;

    @Autowired
    private TestFeign testFeign;

    @RequestMapping("cat/name")
    public String name(){
        return animal.name();
    }

    @RequestMapping("cat/eat")
    public String eat(){
        return animal.eat();
    }

    @RequestMapping("/string")
    public String string(){
        return testFeign.string();
    }

    @RequestMapping("/json")
    public User json(){
        return testFeign.json();
    }

    @RequestMapping("/user")
    public User user(String name){
        return testFeign.user(name);
    }
}
