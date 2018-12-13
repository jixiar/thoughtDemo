package com.dcml.cms.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBean {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);

        People people = (People)context.getBean("test");
        people.sayHello();

    }



}
