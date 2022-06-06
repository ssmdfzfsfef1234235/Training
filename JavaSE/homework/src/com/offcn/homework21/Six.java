package com.offcn.homework21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/*分析以下需求，并用代码实现（此题使用4种方法完成，有一种方法可能会出现问题，课堂上讲）：
	(1)定义Collection集合，存入多个字符串，其中包含三个连续的"def"
	(2)删除集合中字符串"def"
	(3)然后利用迭代器遍历集合元素并输出
	*/
public class Six {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<String>();
        objects.add("def");
        objects.add("def");
        objects.add("def");
        objects.add("abc");
        objects.add("aaaaaaabc");
        System.out.println(objects);
//        test1(objects);
//        test2(objects);
//        test3(objects);
        test4(objects);
        System.out.println(objects);



    }

    private static void test4(List<String> objects) {
        List<String> objects1 = new ArrayList<String>();
        objects1.add("def");
        objects1.add("def");
        objects1.add("def");
        objects.removeAll(objects1);
    }

    private static void test3(List<String> objects) {
        Object[] objects1 = objects.toArray();
        int len = objects1.length;
        for (int i = len-1; i >=0 ; i--) {
            if("def".equals(objects1[i])){

                    System.arraycopy(objects1,i+1,objects1,i,objects1.length-1-i);
                    len--;
//                System.out.println(objects1.toString());
//                    objects1[objects1.length--] = null;
//                for ( i = 0; i < objects1.length; i++) {
//                    objects.add((String) objects1[i]);
//                }

                objects1[objects1.length-1]=null;
            }
        }
        objects1= Arrays.copyOf(objects1,len);
        objects.clear();
        for (int i = 0; i < objects1.length; i++) {
            objects.add((String) objects1[i]);
        }

//        System.out.println(objects);
    }

    private static void test2(List<String> objects) {
        //第二种
        ListIterator<String> stringListIterator = objects.listIterator();
        while (stringListIterator.hasNext()){
            String next = stringListIterator.next();
            if (next.equals("def")){
                stringListIterator.remove();
            }
        }
    }

    private static void test1(List<String> objects) {
        //第一种
        for (int i = 0; i < objects.size(); i++) {
            if(objects.get(i).equals("def")){
                objects.remove(i);
            }
        }
    }
}
