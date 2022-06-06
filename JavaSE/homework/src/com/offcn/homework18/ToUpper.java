package com.offcn.homework18;


import java.util.Scanner;

/*分析以下需求，并用代码实现：
	(1)从键盘循环录入录入一个字符串,输入"end"表示结束
	(2)将字符串中大写字母变成小写字母，小写字母变成大写字母，其它字符用"*"代替,并统计字母的个数
		举例:
			键盘录入：Hello12345World
			输出结果：hELLO*****wORLD
					  总共10个字母*/
public class ToUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String next ="";
        String string="";

        while (flag){
            System.out.println("从键盘循环录入录入一个字符串,输入\"end\"表示结束");
            next = scanner.next();
            if (next.equals("end")){
                flag = false ;
            }
            string = string.concat(next);
        }
        System.out.println(string);
        System.out.println(111);
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] > 'a' && chars[i] < 'z'){
                chars[i] -= 32;
            }else if (chars[i] > 'A' && chars[i] < 'Z'){
                chars[i] += 32;
            }else {
                chars[i] = '*';
            }
        }
        for (int i = 0; i < chars.length ; i++) {
            System.out.print(chars[i]);
        }
    }
}
