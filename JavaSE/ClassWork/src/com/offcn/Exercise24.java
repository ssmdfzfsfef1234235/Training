package com.offcn;

import java.io.File;
import java.util.Scanner;

/*键盘录入一个字符串，表示一个文件夹路径，如果不是文件夹路径则提示重新录入
打印当前文件夹下，所有的大于70M的后缀名是.mp4的文件的绝对路径*/
public class Exercise24 {
    public static void main(String[] args) {
        File dir = getDir();
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()&&file.length()>70*1024*1024&&file.getName().endsWith(".pdf")){
                System.out.println(file);
            }
        }


    }

    private static File getDir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一串路径名：");
        while (true) {
            String s = scanner.nextLine();
            File file = new File(s);
            if (file.isDirectory()) {
                return file;
            }else {
                System.out.println("请输入合法的字符串");
            }

        }
    }
}
