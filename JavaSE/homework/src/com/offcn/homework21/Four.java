package com.offcn.homework21;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*分析以下需求，并用代码实现：
	(1)有如下代码：
		Collection list = new ArrayList();

		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");

		System.out.println(frequency(list, "a"));	// 3
		System.out.println(frequency(list, "b"));	// 2
		System.out.println(frequency(list, "c"));	// 1
		System.out.println(frequency(list, "d"));	// 5
		System.out.println(frequency(list, "xxx"));	// 0
	(2)实现frequency方法统计集合中指定元素出现的次数，如"a" 3,"b" 2,"c" 1*/
public class Four {
//    实现frequency方法统计集合中指定元素出现的次数，如"a" 3,"b" 2,"c"
public static void main(String[] args) {
    Collection list = new ArrayList();

    list.add("a");
    list.add("a");
    list.add("a");
    list.add("b");
    list.add("b");
    list.add("c");
    list.add("d");
    list.add("d");
    list.add("d");
    list.add("d");
    list.add("d");
    System.out.println(frequency(list, "a"));	// 3
    System.out.println(frequency(list, "b"));	// 2
    System.out.println(frequency(list, "c"));	// 1
    System.out.println(frequency(list, "d"));	// 5
    System.out.println(frequency(list, "xxx"));	// 0
}
    public static  int frequency( Collection l,String s){
        Iterator iterator = l.iterator();
        int count = 0;
        while (iterator.hasNext()){
            Object next = iterator.next();
            if (next.equals(s)){
                count ++ ;
            }
        }
        return count;
    }
}
