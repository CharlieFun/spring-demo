package com.netease.spring.demo.study.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fangsida
 * @date 2020/5/7
 */
public class MyLock extends AbstractQueuedSynchronizer {

    static ReentrantLock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();

    static volatile boolean flag = false;


    public static class Thread1 implements Runnable{

        @Override
        public void run() {
            lock.lock();
            System.out.println("线程1获取到锁");

            try{
                System.out.println("线程1执行逻辑");
                while (!flag){
                    System.out.println("条件不满足，线程1挂起");
                    condition.await();
                    System.out.println("线程1被唤醒");
                }
                System.out.println("条件满足，线程1继续执行");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("线程1执行完毕");
            }

        }
    }

    public static class Thread2 implements Runnable{

        @Override
        public void run() {
            try {
                //先等待2s，保证线程1先获取锁
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            lock.lock();
            System.out.println("线程2获取到锁");

            try{
                System.out.println("线程2执行逻辑");
                flag = true;
                condition.signal();
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("线程2执行完毕");
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }
}
