package com.dcml.cms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DemoController {

    @RequestMapping("/")
    public String method() throws IOException{
        //检查异常需要手动抛出到方法外
        throw new IOException();
    }

    @RequestMapping("demo")
    public String demoMethod(){
        //运行时异常 jvm会自动抛出异常
        throw new NullPointerException();
    }


}
