package com.offcn.homework22;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/*使用LinkedHashSet类型完成如下需求：
	定义一个方法，可以对List集合内容进行去重，并且不改变原来List中元素的顺序
* */
public class Six {
    public static void main(String[] args) {
        ArrayList<Object> objects1 = new ArrayList<>();
        objects1.add("aefsr");
        objects1.add("segaa");
        objects1.add("agAEFR");
        objects1.add("aefsr");
        objects1.add("aefsr");
        System.out.println(objects1);
        remove(objects1);


    }

    private static void remove(ArrayList<Object> objects1) {
        LinkedHashSet es = new LinkedHashSet();
        Object[] objects = objects1.toArray();
        for (int i = 0; i < objects.length; i++) {
//            for (int j = i+1; j < objects.length; j++) {
//                if (!objects[i].equals(objects[j])){
                    es.add(objects[i]);
//                    objects1.removeAll(es);

//                }
//            }
        }
        System.out.println(es);
    }
}
