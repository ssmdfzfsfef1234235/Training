package com.offcn.homework28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*1、定义一个能够表示宿舍成员的枚举类型，枚举类型中定义量个成员变量：姓名，年龄
采用合适的集合，将枚举项添加到这个集合中，分别按照以下规则排序，展示三种排序结果：
① 第一种结果：枚举项的定义倒序排序
② 第二种结果：姓名的字典顺序对枚举项排序
③ 第三种结果：年龄的正序对枚举项排序*/
public class One {
    public static void main(String[] args) {
        ArrayList<Department> Departments = new ArrayList<>();
        Departments.add(Department.GJJ);
        Departments.add(Department.SSM);
        Departments.add(Department.XHM);
        System.out.println(Departments);
//        System.out.println(Department.SSM.compareTo(Department.XHM));
//        test1(Departments);
//        test2(Departments);
//        ③ 第三种结果：年龄的正序对枚举项排序
        Collections.sort(Departments, new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(Departments);

    }

    private static void test2(ArrayList<Department> departments) {
        //        ② 第二种结果：姓名的字典顺序对枚举项排序
        Collections.sort(departments, new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return -(o1.getName().compareTo(o2.getName()));
            }
        });
        System.out.println(departments);
    }

    private static void test1(ArrayList<Department> departments) {
        //                ① 第一种结果：枚举项的定义倒序排序
        Collections.sort(departments, new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return -(o1.compareTo(o2));
            }
        });
        System.out.println(departments);
    }
}
enum Department{
    SSM("佘思敏",22),XHM("熊慧敏",27),GJJ("高雨柔",28);
    private String name;
    private int age;

    Department() {
    }

    Department(String name, int age) {
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

    @Override
    public String toString() {
        return "Apartment{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}