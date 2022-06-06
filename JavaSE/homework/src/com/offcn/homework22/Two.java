package com.offcn.homework22;

import java.util.Random;

/*   快         慢
比较ArrayList和LinkedList查询元素的效率
**/
public class Two {
    public static void main(String[] args) {
        LinkStack<String> list1 =new LinkStack();
        ArrayStack<String> list2 =new ArrayStack<>();
        for (int i = 0; i < 10000; i++) {
            String s = String.valueOf(new Random().nextInt(100));
            list1.push(s);
//            System.out.println(list1.pop());
        }
        long start = System.currentTimeMillis();
        System.out.println(list1.get("99").toString());

        long end = System.currentTimeMillis();
        list1.print();
        System.out.println("LinkedList所用时间"+(end-start));

        for (int i = 0; i < 10000; i++) {
            String s = String.valueOf(new Random().nextInt(100));
            list2.push(s);
        }
        long start1 = System.currentTimeMillis();
        System.out.println(list2.get("99").toString());
        long end1 = System.currentTimeMillis();
        list2.print();
        System.out.println("ArrayList所用时间"+(end1-start1));


    }
}
