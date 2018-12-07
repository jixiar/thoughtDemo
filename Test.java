package com.dcml.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    private String name="tom";

    @Autowired
    private static Test test;

    public Test(){
        test = this;
    }

    public static void main(String[] args){
        //Test test = new Test(); //需要先实例化
        //System.out.println(test.name);

        Student s = new Student();
        s.setAge(3);
        System.out.println(s.getAge());
    }

}

class Student{
    @TestAnno
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
