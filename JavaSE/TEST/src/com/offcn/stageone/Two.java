package com.offcn.stageone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*2、题目：取出一个字符串中字母出现的次数。（25分）
注意：
1、数字不算字母
2、输出的结果，根据出现次数从多到少 如：字符串："abcdekka27qoq" ，输出格式为：a(3)b(1)k(2)...
1）定义合适字符串（3分，作答时长5分钟）
2）设计算法过滤掉数字符号 (7分，作答时长5分钟）
3）选择合适的类统计字符出现的次数（10分，作答时长10分钟）
4）按照格式输出每个字母字符的信息（5分，作答时长10分钟）*/
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("定义合适字符串,取出一个字符串中字母出现的次数");
        String s = scanner.nextLine();
        HashMap<Character, Integer> sih = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar>'a'&&aChar<'z'){
                sih.put(aChar,sih.containsKey(aChar)?sih.get(aChar)+1:1);
            }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : sih.entrySet()) {
            System.out.println(characterIntegerEntry.getKey() + "(" + characterIntegerEntry.getValue() + ")");
        }
    }
}
