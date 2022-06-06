package com.offcn.homework21;



import java.util.Random;

/*结合随机数，实现本班的随机点名器（人名字可以自己编）
 */
public class Three {
    public static void main(String[] args) {
        String[] s = {"sajfdbiu","ihufwugwu","baufgw","dhvusgu","sieufgu","ksehfiuwhy","iuwhfeiuh","gaufwgf"};
        Random random = new Random();
        int i = random.nextInt(s.length);
        System.out.println(s[i]);
    }
}
