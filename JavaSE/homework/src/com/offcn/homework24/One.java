package com.offcn.homework24;

import java.io.File;
import java.util.Scanner;

/*1、键盘录入一个文件夹路径（文件夹中只包含若干文件，不包含文件夹），删除该文件夹（包含文件夹内容）

2、键盘录入一个文件夹路径（文件夹中只包含若干文件，不包含文件夹），统计该文件夹的大小

3、键盘录入一个文件夹路径（文件夹中只包含若干文件，不包含文件夹），统计该文件夹下的各种后缀名的文件的个数
	例如：.txt有10个，.java有30个......
*/
public class One {
    public static void main(String[] args) {
        File dir = getDir();
        del(dir);


    }

    private static void del(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            file.delete();
        }
        dir.delete();
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
