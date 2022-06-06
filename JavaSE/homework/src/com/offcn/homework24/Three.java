package com.offcn.homework24;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
3、键盘录入一个文件夹路径（文件夹中只包含若干文件，不包含文件夹），统计该文件夹下的各种后缀名的文件的个数
	例如：.txt有10个，.java有30个......*/
public class Three {
    public static void main(String[] args) {
        File dir = getDir();
        count(dir);

    }

    private static void count(File dir) {
        HashMap<String, Integer> sihm = new HashMap<>();
        File[] files = dir.listFiles();
        for (File file : files) {
            String name = file.getName();
            String[] split = name.split("\\.");
            if (sihm.containsKey(("." + split[1]))) {
                sihm.put(("." + split[1]), sihm.get(("." + split[1])) + 1);
            } else {
                sihm.put(("." + split[1]), 1);
            }
        }
        for (Map.Entry<String, Integer> sie : sihm.entrySet()) {
            System.out.println(sie.getKey()+"有"+sie.getValue()+"个");

        }
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
