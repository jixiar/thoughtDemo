package com.dcml.cms.controller;

public class ServiceB {
    public void createUser(CallBack callBack,final String userName){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("ServiceB 创建用户 " + userName + "成功");
                callBack.process(" 创建用户 " + userName + "成功");
            }
        }).start();
    }
}
