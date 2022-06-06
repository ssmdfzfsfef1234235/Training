package com.offcn.test;

import java.util.Scanner;

public class Test2 {
//定义一个容量大小为5的数组，用于储存Studnet对象
//3、使用循环陆续创建5个Student 对象,通过键盘录入对象的属性,并使用有参构造对属性进行赋值。
//4、将创建的 Student 对象存入创建好的数组中; 5、 遍历数组中的 Student对象
public static void main(String[] args) {
    Student[] stu = new Student[5];
    for (int i = 0; i < stu.length; i++) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入student的名字");
        String a = sc.next();
        System.out.println("请输入student的年龄");
        int b = sc.nextInt();
        stu[i] = new Student(a,b);
    }
    for (int i = 0; i < stu.length; i++) {

        stu[i].show();

    }
}
}
/*1、定义一个Student类，里面有私有的成员变量name和age，提供有参和无参构造方法以及能够展示对
象属性的show方法
2、定义一个容量大小为5的数组，用于储存Studnet对象
3、使用循环陆续创建5个Student 对象,通过键盘录入对象的属性,并使用有参构造对属性进行赋值。
4、将创建的 Student 对象存入创建好的数组中; 5、 遍历数组中的 Student对象*/
class Student{
    private  String name;
    private  int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println("我叫"+getName()+getAge()+"岁");
    }
}
