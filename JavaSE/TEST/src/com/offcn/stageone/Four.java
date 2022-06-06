package com.offcn.stageone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/*4、题目：创建三个类，Cat,Dog,Monkey，都在com.ujiuye.beans包下, 他们都有eat方法， 但吃的内容都不相同，使用反射的方式，用户可以自己输入类名，创建对象，并执行eat方法。（25分）
如：输入Dog， 就执行Dog类eat的方法
1）定义Cat类（2分，作答时长4分钟）
2）定义Dog类（2分，作答时长4分钟）
3）定义Monkey类（2分，作答时长4分钟）
4）定义输入类名功能（4分，作答时长4分钟）
5）使用反射获得类对象（5分，作答时长5分钟）
6）使用反射获取方法对象（5分，作答时长5分钟）
7）执行eat方法（5分，作答时长4分钟）
*/
public class Four {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户可以自己输入类名Cat,Dog,Monkey，创建对象，并执行eat方法");
        String s = scanner.nextLine();
        Class<?> aClass = Class.forName("com.offcn.stageone."+s);
        Object o = aClass.newInstance();
        Method eat = aClass.getDeclaredMethod("eat");
        eat.setAccessible(true);
        eat.invoke(o);

    }
}
class Cat{
    private void eat(){
        System.out.println("猫吃鱼");
    }
}
class Dog{
    private void eat(){
        System.out.println("狗吃肉");
    }
}
class Monkey{
    private void eat(){
        System.out.println("猴子吃香蕉");
    }
}
