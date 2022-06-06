package com.offcn.homework23;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*分析以下需求，并用代码实现：
	(1)利用键盘录入，输入一个字符串
	(2)统计该字符串中各个字符的数量
	(3)如：
		用户输入字符串"If~you-want~to~change-your_fate_I_think~you~must~come-to-the-ujiuye-to-learn-java"
		程序输出结果：-(9)I(2)_(3)a(7)c(2)d(1).....
		*/
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<Character, Integer> osh = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (osh.containsKey(aChar)) {
                osh.put(aChar, osh.get(aChar) + 1);
            } else {
                osh.put(aChar, 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = osh.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.print(entry.getKey()+"("+entry.getValue()+")");

        }
    }
}
