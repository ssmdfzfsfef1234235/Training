package com.offcn.homework28;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*5、创建一个ArrayList<String> 集合,通过反射向集合中添加Integer类型的数据*/
public class Five {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ArrayList<String> list=new ArrayList<>();
        Class<? extends ArrayList> aClass = list.getClass();

        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list,(Integer)1);
        System.out.println(list);

    }
}
