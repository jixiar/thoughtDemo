package org.springfans.referral.controller;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class YamlTest {

    public static void main(String[] args) throws Exception {

        yamlToObject(new File("stu.yml"));
    }

    static void yamlToObject(File file) throws FileNotFoundException{
        Yaml yaml = new Yaml();
        Student student = (Student) yaml.load(new FileReader(file));
        System.out.println(student.toString());



        Object object = yaml.load(new FileInputStream(file));
        System.out.println(object);

    }

    static void objectToYaml() throws IOException{
        Student stu = new Student();
        stu.setAge(23);
        stu.setName("tom");
        stu.setId(1);
        Tel t = new Tel();
        t.setName("jack");
        t.setTel("123");
        Tel t1 = new Tel();
        t1.setName("david");
        t1.setTel("456");
        List<Tel> list = new ArrayList<>();
        list.add(t);
        list.add(t1);
        stu.setTels(list);
        Yaml yaml = new Yaml();
        yaml.dump(stu,new FileWriter("stu.yml"));
    }


}

