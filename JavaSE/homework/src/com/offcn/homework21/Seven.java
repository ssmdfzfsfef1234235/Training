package com.offcn.homework21;
/*分析以下需求，并用代码实现（使用传统方式和正则方式，两种办法完成）：
	(1)定义Collection集合，存入多个字符串
	(2)删除集合中包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串)
	(3)然后利用迭代器遍历集合元素并输出
	*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Seven {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        strings.add("bujbw4283768");
        strings.add("buj876876a768");
        strings.add("bujbw");
        strings.add("bujbw");
        strings.add("bujdsbdh75768");
//        ListIterator t = test1(strings);
//        while(t.hasNext()) {
//            System.out.println(t.next());
//        }
            test1(strings);
    }

    private static void test1(List<String> strings) {
        ListIterator<String> stringListIterator = strings.listIterator();
        while (stringListIterator.hasNext()){
            String next = stringListIterator.next();
            char[] chars = next.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > '0' && chars[i] < '9'){
                    stringListIterator.remove();
                }
            }
        }
        System.out.println(stringListIterator);
    }

}
