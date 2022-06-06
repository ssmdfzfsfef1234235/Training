package com.offcn.ClassWork25;

import java.io.File;
import java.util.Scanner;

/*键盘录入一个文件夹路径，使用递归打印这个文件夹下的所有文件的绝对路径（包含子文件夹的内容）*/
public class Exercise25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("键盘录入一个文件夹路径");
        String s = scanner.nextLine();
        File file = new File(s);
        Exercise25.print(file);


    }

    private static void print(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()){
                System.out.println(file1.getAbsolutePath());
            }else{
                Exercise25. print(file1);
            }
        }
    }


}
