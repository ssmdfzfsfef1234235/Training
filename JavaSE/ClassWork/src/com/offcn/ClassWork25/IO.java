package com.offcn.ClassWork25;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\笔记\\代码\\src\\com\\offcn\\demos\\Demo01_Constructor.java");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Java.txt");
        int read = 0;
        while (read!=-1){
            read = fileInputStream.read();
            fileOutputStream.write(read);
        }
        System.out.println(System.getProperty("user.dir"));

        fileInputStream.close();
        fileOutputStream.close();

    }
}
