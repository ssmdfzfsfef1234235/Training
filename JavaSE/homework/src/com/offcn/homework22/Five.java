package com.offcn.homework22;

import java.util.Scanner;

/*、
使用Scanner从键盘读取一行输入(字符串),去掉其中重复字符, 打印出不同的那些字符
 */
public class Five {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j <chars.length ; j++) {
                if (chars[i] == chars[j]){
                    System.arraycopy(chars,i+1,chars,i,chars.length-i-1);
                    chars[chars.length-1]='\u0000';
                    System.arraycopy(chars,j+1,chars,j,chars.length-j-1);
                    chars[chars.length-1]='\u0000';
                }
            }
        }
        for (char aChar : chars) {
            System.out.print(aChar);
        }
    }
}
