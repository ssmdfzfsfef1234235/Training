package com.offcn.homework23;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/*1、使用LinkedHashSet类型完成如下需求：
	定义一个方法，可以对List集合内容进行去重，并且不改变原来List中元素的顺序
	*/
public class One {
    public static void main(String[] args) {

        ArrayList<String> s = new ArrayList<>();
        LinkedHashSet lS = new LinkedHashSet();

        s.add("uhyfdtrcxd");
        s.add("juftdt");
        s.add("iguyud5uy");
        s.add("uhyfdtrcxd");
        s.add("yugyufdt");
        s.add("uhyfdtrcxd");
        System.out.println(s);

        for (String s1 : s) {
            lS.add(s1);
        }
        System.out.println(lS);



    }
}
