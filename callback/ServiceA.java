package com.dcml.cms.controller;

public class ServiceA {
    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB){
        this.serviceB = serviceB;
    }

    public void createUser(String userName){
        serviceB.createUser(new CallBack() {
            @Override
            public void process(String result) {
                System.out.println("serviceB 回调返回消息" + result);
            }
        },userName);

    }
}
