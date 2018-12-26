package com.dcml.cms.controller;

public class ShareCached {

    private char cache;

    private boolean flag = false;

    public synchronized void addShareCachedData(char data){
        if(flag){
            System.out.println("产品未消费，生产者生产操作等待");
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        this.cache = data;
        flag = true;
        notify();
        System.out.println("产品"+data+"，已生产，通知消费者消费");
    }

    public synchronized char getShareCachedData(){
        if(!flag){
            System.out.println("产品未生产，消费者消费操作等待");
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        flag = false;
        notify();
        System.out.println("产品"+this.cache+"，以消费，通知生产者生产");
        return this.cache;
    }

    //输出 通过异步处理可以帮助消费者和生产者按照合理的方式执行
    //通过 synchronized和 wait();notify(); 锁定对象方法，并且等待和唤醒线程
    /*产品A，已生产，通知消费者消费
    产品A，以消费，通知生产者生产
    产品B，已生产，通知消费者消费
    产品未消费，生产者生产操作等待
    产品B，以消费，通知生产者生产
    产品C，已生产，通知消费者消费
    产品C，以消费，通知生产者生产
    产品D，已生产，通知消费者消费
    产品D，以消费，通知生产者生产*/

}
