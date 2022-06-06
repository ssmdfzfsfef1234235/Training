package com.offcn.homework21;

import java.text.SimpleDateFormat;
import java.util.Date;

//1、输出当前时间的年、月、日、时、分、秒和星期几
public class One {
    public static void main(String[] args) {

       // System.out.println(System.currentTimeMillis()/1000/60/60/24/365);

        Date d = new Date();

        System.out.println(d);

        SimpleDateFormat sDF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss E");

        String format = sDF.format(d);

        System.out.println(format);

    }
}
