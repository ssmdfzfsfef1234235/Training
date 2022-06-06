package com.offcn.homework22;

import java.util.HashSet;

/*
【问题描述】（注意理解题意，题目本身不难，但是题干很绕）
一个字符串的非空子串是指字符串中长度至少为 1 的连续的一段字符组成 的串。
例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个。
注意在计算时，只算本质不同的串的个数。
请问，字符串0100110001010001 有多少个不同的非空子串？
【正确答案】
*/
public class Three {
    public static void main(String[] args) {
        HashSet<String> b = new HashSet<>();
        String s = "0100110001010001";
        int count = 0 ;
        System.out.println(b.toString());
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if(!b.contains(s.substring(i,j))){
                    b.add(s.substring(i,j));
                    count++;
                }
            }
        }
        System.out.println(b.toString());
        System.out.println(count);
    }

}
