package com.funstar.springdemo.service.impl;

import com.funstar.springdemo.service.Animal;

public class Cat implements Animal {

    private String name = "Tom";

    public Cat(){
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String run() {
        return "I run with four legs";
    }

    @Override
    public String eat() {
        return "I love fish";
    }

    public static void main(String[] args) {
        System.out.println(Cat.class.getTypeName());
    }
}
