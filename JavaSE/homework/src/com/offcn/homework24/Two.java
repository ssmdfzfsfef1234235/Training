package com.offcn.homework24;

import java.io.File;
import java.util.Scanner;

/*2、键盘录入一个文件夹路径（文件夹中只包含若干文件，不包含文件夹），统计该文件夹的大小*/
public class Two {
    public static void main(String[] args) {
        File dir = getDir();
        System.out.println(length(dir));
    }

    private static long length(File dir) {
        File[] files = dir.listFiles();
        long length = 0;
        for (File file : files) {
             length += file.length();
        }
        return length;
    }

    private static File getDir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("键盘录入一个文件夹路径（文件夹中只包含若干文件，不包含文件夹）");
        while (true) {
            String s = scanner.nextLine();
            File file = new File(s);
            File[] files = file.listFiles();
            int i = 0;
            for (File f : files) {
                if (!f.isFile()){

                    i++;
                }
            }
            if (i==0){
                return file;
            }else {
                System.out.println("请输入文件夹中只包含若干文件，不包含文件夹的文件夹路径");
            }

        }
    }
}
