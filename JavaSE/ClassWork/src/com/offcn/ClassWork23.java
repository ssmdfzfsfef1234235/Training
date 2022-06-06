package com.offcn;

import java.util.*;

/*键盘录入一个字符串，统计每个字符出现的次数
例如，录入aaaabbccddd!@#@#$@#$%cc66ff
打印出来：a有4个，b有2个，c有4个，d有3个，!有1个，@有3个，$有2个，%有1个，6有2个，f有2个
*/
public class ClassWork23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Character,Integer> sHashMap = new HashMap<>();
        int i = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (sHashMap.containsKey(aChar)){
                sHashMap.put(aChar,sHashMap.get(aChar)+1);
            }else {
                sHashMap.put(aChar,1);
            }

        }
        Set<Map.Entry<Character, Integer>> entries = sHashMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            System.out.println(next);
        }


    }
}
