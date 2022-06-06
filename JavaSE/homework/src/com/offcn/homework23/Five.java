package com.offcn.homework23;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

/*(选做题，难度大)给定一个字符串，该字符串只能包括下列字符：
	'(',')','{','}','[',']'
	判断字符串是否有效。
	有效字符串必须满足：
		① 左括号必须用相同类型的又括号闭合
		② 左括号必须以正确的顺序闭合

	例如：输入："()"，输出：true
		  输入："()[]{}"，输出：true
		  输入："({)}"，输出：false
		  输入："{[]}"，输出：true
*/
public class Five {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(check(s));


    }

    private static boolean check(String s) {
        HashMap<Character, Character> cch = new HashMap<>();
        cch.put(')','(');
        cch.put(']','[');
        cch.put('}','{');
        ArrayDeque<Character> cs = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (cch.containsValue(aChar)) {
                cs.push(aChar);
            }else if(cch.containsKey(aChar)){
                if(cs.isEmpty()){
                    return false;
                }
                if(cs.peek().equals(cch.get(aChar))){
                    cs.pop();
                }else {
                    return false;
                }
            }
        }
        return cs.isEmpty();
    }
}
