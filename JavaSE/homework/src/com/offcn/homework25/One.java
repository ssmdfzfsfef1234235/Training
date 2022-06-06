package com.offcn.homework25;

import java.io.File;
import java.util.Scanner;

/*1、键盘录入一个文件夹路径，删除该文件夹（包含文件夹内容）*/
public class One {
    public static void main(String[] args) {
        File s1 = getDir();
        One.delete(s1);
    }

    static File getDir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("键盘录入一个文件夹路径，删除该文件夹（包含文件夹内容）");
        String s = scanner.nextLine();
        return new File(s);
    }

    private static void delete(File s1) {

        File[] files = s1.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                One.delete(file);
            }else {

                file.delete();
                System.out.println(file.getName());
            }
        }
        s1.delete();

    }
}
