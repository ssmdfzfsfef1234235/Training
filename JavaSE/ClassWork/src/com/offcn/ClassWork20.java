package com.offcn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;/*
构造方法：
Date() 创建Date对象，表示的时间是1970年1月1日0时0分0秒（GMT）到创建对象刹那的毫秒值
Date(long date) 创建Date对象，通过参数date来指定时间的毫秒值

成员方法：
long getTime() 获取Date对象中的毫秒数。
void setTime(long time) 向Date对象中设定time参数所指定的毫秒值

打印Date对象，自带默认的时间格式
*/

/*
父类方法：
String format(Date date) Date -> 想要的日期文本格式
Date parse(String source) 日期文本格式 -> Date

实现子类：

构造方法：
SimpleDateFormat() 创建SimpleDateFormat对象，其自带默认日期格式，其和语言环境有关
SimpleDateFormat(String pattern) 创建SimpleDateFormat对象，其日期格式通过pattern参数指定

*/

/*键盘录入一个自己的生日，计算今天是自己出生的第几天*/
public class ClassWork20 {
    public static void main(String[] args) throws ParseException {
//        Date date = new Date();
//        Date date1 = new Date(1999,05,14);
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy/MM/dd");
//        String format = simpleDateFormat.format(date);
//        String format1 = simpleDateFormat.format(date1);
//        System.out.println(format1);
        //1.键盘录入String
        System.out.println("键盘录入一个自己的生日,格式yyyy-MM-dd");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //2.string-》date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(s);
        //3.date->毫秒
        long time = parse.getTime();
        long l = System.currentTimeMillis();
        //4.计算
        System.out.println("今天是自己出生的第"+((l-time)/1000/60/60/24)+"天");


    }

}
