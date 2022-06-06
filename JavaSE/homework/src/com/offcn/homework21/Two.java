package com.offcn.homework21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*分析以下需求，并用代码实现：
	(1)通过键盘录入日期字符串，格式(2021-01-01)
	(2)输出该日期是星期几及这一年的第几天
	(3)如输入：2021-01-01，输出"2021年-01月-01日是星期五，是2021年的第1天"
	*/
public class Two {

    public static void main(String[] args) throws ParseException {

        System.out.println("通过键盘录入日期字符串，格式(2021-01-01)");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(s);
        System.out.println(parse);

//        输出该日期是星期几及这一年的第几天
//        long t = parse.getTime();
//        System.out.println(t);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年-MM月-dd日是E，是yyyy年的第D天");
        String parse1 = sdf1.format(parse);
        System.out.println(parse1);
        //年
//        String sb1 = parse1.substring(0, 4);
//        int i = Integer.parseInt(sb1);
//        System.out.println(sb1);
//        String sb2 = parse1.substring(4, 6);
//        int j = Integer.parseInt(sb2);
//        System.out.println(sb2);
//        String sb3 = parse1.substring(6, 8);
//        int k = Integer.parseInt(sb3);
//        System.out.println(sb3);
//
//        SimpleDateFormat sdf2 = new SimpleDateFormat("E");

//       sdf.applyLocalizedPattern("yyyy年-MM月-dd日是E");
//        System.out.println("输出该日期是"+parse2+"及这一年的第"+dayOfYear(i,j,k)+"天");


//        System.out.println(parse1);


    }
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0 ;
    }
    public static int dayOfYear(int year , int month ,int day){
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(isLeapYear(year)){
            days[1] = 29;
        }
        for (int i = 0; i < month - 1; i++) {
            day +=days[i];
        }
        return day;
    }
}
