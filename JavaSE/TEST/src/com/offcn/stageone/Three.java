package com.offcn.stageone;

import java.util.ArrayList;
import java.util.Scanner;

/*3、题目：使用数组完成以下操作。（25分）
1) 定义一个Student类，里面有私有的成员变量name和age，提供有参和无参构造方法以及能够展示对象属性的show方法 （5分，作答时长5分钟）
2) 定义一个容量大小为5的数组，用于储存Studnet对象 (5分，作答时长5分钟）
3) 使用循环陆续创建5个Student 对象,通过键盘录入对象的属性,并使用有参构造对属性进行赋值。(5分，作答时长15分钟）
4) 将创建的 Student 对象存入创建好的数组中; （5分，作答时长5分钟）
5) 遍历数组中的 Student对象，打印所有对象的属性值; （5分，作答时长10分钟）*/
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用循环陆续创建5个Student 对象,通过键盘录入对象的属性,并使用有参构造对属性进行赋值。");
        ArrayList<Student> students = new ArrayList<>();
        String s=null;
        int j;
        for (int i = 0; i < 5; i++) {
            System.out.println("通过键盘录入对象的属性name");
             s = scanner.nextLine();
            System.out.println("通过键盘录入对象的属性age");
             j = Integer.parseInt(scanner.nextLine());
             students.add(new Student(s,j));
        }
        for (Student student : students) {
            System.out.println(student.show());
        }
    }
}
class Student{
    String name;
    int age;

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

    public  String show() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
