package com.offcn.ClassWork19;
/*
* 定义一个方法，接收一个String类型的字符串，返回该字符串的反转形式
举例：接收字符串为abc，返回字符串为cba
要求：使用StringBuilder进行反转，提高开发效率
* */
public class Reverse {
    public static void main(String[] args) {
        String s = new String("kahusfc");
        s=reverse(s);
        System.out.println(s);

    }
    public static String reverse(String a){
        StringBuilder stringBuilder = new StringBuilder(a);
        stringBuilder.reverse();
        String s = stringBuilder.toString();
        return s;
    }
}
