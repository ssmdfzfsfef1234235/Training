package com.offcn.homework23;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*、分析以下需求，并用代码实现：
	(1)统计每个单词出现的次数
	(2)有如下字符串"If you want to change your fate I think you must come to the ujiuye to learn java"(用空格间隔)
	(3)打印格式：
		to=3
  		think=1
  		you=2
  		//........*/
public class Four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<String, Integer> st = new HashMap<>();
        String[] s1 = s.split(" ");
        /*for (String s2 : s1) {
            System.out.println(s2);
        }*/
        for (String s2 : s1) {
            if (st.containsKey(s2)) {
                st.put(s2, st.get(s2) + 1);
            } else {
                st.put(s2, 1);
            }
        }
        for (Map.Entry<String, Integer> st2 : st.entrySet()) {
            System.out.print(st2);
        }
    }
}
