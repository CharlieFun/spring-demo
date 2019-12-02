package com.funstar.feign.demo.service.impl;

import com.funstar.feign.demo.service.Animal;

import java.util.concurrent.*;

public class Cat implements Animal {

    private String name = "Tom";

    private static final ExecutorService executorService  = new ThreadPoolExecutor(3,3,30L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

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
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            try{
                Thread.sleep(4000);
            }catch (Exception e){
                //pass
            }
            return "good";
        });
        executorService.submit(futureTask);
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "false";
    }

    public static void main(String[] args) {
        System.out.println(Cat.class.getTypeName());
    }
}
