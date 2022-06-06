package com.offcn.homework25;

import java.io.File;

/*2、键盘录入一个文件夹路径，统计该文件夹的大小
* */
public class Two {
    public static void main(String[] args) {
        File dir = One.getDir();
        System.out.println(count(dir));//592,838,564 字节


    }

    private static long count(File dir) {
        long length = 0;
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                length += file.length();
            }else {
                length +=count(file);
            }
        }
        return length;
    }
}
