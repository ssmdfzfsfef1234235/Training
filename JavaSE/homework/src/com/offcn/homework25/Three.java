package com.offcn.homework25;

import java.io.File;
import java.util.HashMap;

/*3、键盘录入一个文件夹路径，统计该文件夹下的各种后缀名的文件的个数
	例如：.txt有10个，.java有30个......
	*/
public class Three {
    public static void main(String[] args) {
        File dir = One.getDir();
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        count(dir, stringIntegerHashMap);
        System.out.println(stringIntegerHashMap);
    }

    private static void count(File dir, HashMap<String, Integer> map) {
        File[] files = dir.listFiles();
        for (File file : files) {

            if (file.isFile()) {
                String name = file.getName();
                int i = name.lastIndexOf(".");
                String suffix = name.substring(i);
                map.put(suffix, map.containsKey(suffix) ? map.get(suffix) + 1 : 1);
            } else {
                count(file,map);
            }
        }
    }
}
