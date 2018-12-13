package com.dcml.cms.controller;

public class People {

    private String name;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void sayHello(){
        System.out.println("hello");
    }

    public void start(){
        System.out.println("bean初始化");
    }

    public void cleanUp(){
        System.out.println("bean销毁");
    }
}
