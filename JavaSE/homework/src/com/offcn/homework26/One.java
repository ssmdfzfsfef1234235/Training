package com.offcn.homework26;

import java.io.*;

/*1、当我们下载一个试用版软件,没有购买正版的时候,每执行一次就会提醒我们还有多少次使用机会用学过的IO流知识,
模拟试用版软件,试用10次机会,执行一次就提示一次您还有几次机会,如果次数到了提示请购买正版
（题目解析：java创建的变量在内存中，无法持久化，例如使用一个变量记录次数，代码每次运行，
变量都会创建，所以次数都是10次。但是将次数写在文件里，文件存在磁盘上能持久化，每次运行通过IO流
操作文件中记录的次数，使次数减少，这个次数都会被持久保存。例如，这一次运行你的代码剩余次数使10，
下次运行代码再读取到就是9次。至于题目中模拟使用版软件，使用输出语句提示一下就行）
*/
public class One {
    public static void main(String[] args)  {
       //\homework\src\com\offcn\homework26\count.txt
        BufferedReader br = null;
        String s=null;
        try {
            //E:\IDEA\CODE\JavaSE\homework\src\com\offcn\homework26\count
            br = new BufferedReader(new FileReader("homework\\src\\com\\offcn\\homework26\\count"));
             s= br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int count= Integer.parseInt(s);
        while (true){
            if(count>0){
                System.out.println("程序运行中---------");
                count--;
                System.out.println("还剩"+count+"此机会");
                FileWriter fw = null;
                try {
                    fw = new FileWriter("homework\\src\\com\\offcn\\homework26\\count");
                    fw.write(String.valueOf(count));
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if (fw != null) {

                            fw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                break;
            }
        }



    }
}
