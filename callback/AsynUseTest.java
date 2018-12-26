package com.dcml.cms.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.common.util.concurrent.Service;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import javax.imageio.ImageIO;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.swing.text.html.parser.Entity;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.max;
import static java.lang.Math.random;

@Controller
public class AsynUseTest  {
    public static void main(String[] args) throws Exception {
        //test1
        /*System.out.println("---主线程开始---");
        ServiceB serviceB = new ServiceB();
        ServiceA serviceA = new ServiceA(serviceB);
        System.out.println("主线程调用异步处理");
        serviceA.createUser("kobe");
        System.out.println("主线程继续执行。。。");*/

        //testArrayReverse();

       /* List list = new ArrayList();
        list.add(new User());
        list.add(2);
        list.add(3);

        new User().toString();

        System.out.println(list);


        List<String> lines = new ArrayList<>(1);
        lines.add("aaa");
        lines.add("bbb");
        System.out.println(lines);*/

        /*Date date = java.text.DateFormat.getDateInstance().parse("2016-01-01");
        //System.out.println(date);

        DateFormat df = new SimpleDateFormat();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = format.parse("01.01.2018");
        System.out.println(date1);


        FileChannel fc = new FileInputStream("").getChannel();

        try{
            int maxCount = (64 * 1024 * 1024) - (32 * 1024);

        }finally {

        }

        Robot robot = new Robot();*/

        //captureScreen("bbb.png");

        /*Scanner scanner = new Scanner(System.in);
        String in = "";
        while (!"over".equals(in)){
            in = scanner.nextLine();
            if(checkParameter(in))
                System.out.println(in+"匹配");
            else
                System.out.println(in+"不匹配");
        }*/

        //System.out.println("test assert");
        //
        //assert true;
        //System.out.println("assert success");
        //assert false;
        //System.out.println("assert fail");
        //
        //Assert.hasLength("");

        /*ShareCached shareCached = new ShareCached();
        new Consumer(shareCached).start();
        new Producer(shareCached).start();

        ServletContextListener contextListener = new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {

            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {

            }
        };*/

        /*System.out.println(getNowDate(new Date()));
        System.out.println(new Date());

        Instant instant = Instant.now();

        Date date = new Date(instant.toEpochMilli());
        Date date1 = Date.from(instant);

        System.out.println(instant);

        System.out.println(date);
        random();

        Random random = new Random();
        random.nextBoolean();

        for (int i = 0; i < 1; i++) {
            System.out.println(random.nextBoolean());
        }

        System.currentTimeMillis();

        System.out.println(20.0/3);
        System.out.println(20.0%3);




        Instant instant1 = date.toInstant();
        Date date2 = Date.from(instant1);
        System.out.println(instant1);
        System.out.println(date2);

        JsonObject jb = new JsonObject();
        jb.addProperty("1",instant1.toString());
        jb.addProperty("2",date2.toString());

        System.out.println(jb);

        LocalDate localDate = LocalDate.now();

        localDate = localDate.plusDays(-20);

        System.out.println(localDate);

        LocalDate localDate1 = LocalDate.of(2018,12,31);
        System.out.println(localDate1);
        System.out.println(localDate1.plusDays(1));*/

        /*String name = "helloWorld";
        String name1 = "helloWorld";
        //数组拷贝
        System.arraycopy(name.toCharArray(),1,name.toCharArray(),1,5);*/

        Map<String,String> paraMap = new HashMap<>();
        paraMap.put("111","222");
        Set<String> set = paraMap.keySet();
        for(String key : set){
            String values = paraMap.get(key);
        }

        for(Map.Entry<String, String> entry : paraMap.entrySet()){
            String key = entry.getKey();
            String values = entry.getValue();
        }

        //set 有迭代器
        Set<Map.Entry<String,String>> entrySet = paraMap.entrySet();
        Iterator<Map.Entry<String,String>> iter = entrySet.iterator();

        while(iter.hasNext()){
            Map.Entry<String,String> entry = iter.next();
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }

        //线程池 可以动态配置线程数 并且能够重用线程
        //其中 ThreadLocal用于线程之间的数据存储和传递
        ThreadLocal tl = new ThreadLocal();
        //ThreadLocal.ThreadLocalMap threadLocals = null;

        System.out.println(Objects.equals("1","2"));

        Date date = new Date();
        Date date1 = new Date();
        if(date.before(date1))
            System.out.println(" ");

        date.compareTo(date1);









        paraMap.remove("key");
        String arr = Arrays.toString(new int[]{1,1,1,1,1,1});
        System.out.println(arr);













    }

    public static Date getNowDate(Date date) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return strToDate(dateString);
    }

    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    static void testArrayReverse(){
        long start = System.currentTimeMillis();
        String[] data = {"A","B","C","D","E"};
        System.out.println(Arrays.toString(data));
        Collections.reverse(Arrays.asList(data));
        System.out.println(Arrays.toString(data));
        long end = System.currentTimeMillis();

        System.out.println("执行时间" + (end - start));

    }

    static void captureScreen(String fileName) throws Exception {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image,"png",new File(fileName));
    }

    static void createPDF() throws FileNotFoundException {
        OutputStream file = new FileOutputStream(new File(""));


    }

    static boolean checkParameter(String par){
        return par.matches("[a-zA-Z0-9_]{1,50}");
    }
}

class User{
}
