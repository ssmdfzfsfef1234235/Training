package com.offcn.homework22;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
4、创建一个学生类，属性：姓名，年龄
创建一个List集合，添加5个学生对象
编写一个方法，能够对List集合去重
例如：List集合中的学生对象，如果姓名和年龄相同，就视为重复元素，进行去重
* */
public class Four {
    public static void main(String[] args) {
        List<Student> s = new ArrayList<>();

        s.add(new Student("张三", 21));
        s.add(new Student("李四", 22));
        s.add(new Student("王五", 23));
        s.add(new Student("赵六", 24));
        s.add(new Student("张三", 21));
        System.out.println(s);

        remove(s);
        System.out.println(s);



    }

    private static void remove(List<Student> s) {
        for (int i = s.size()-1; i >=0; i--) {
            for (int j = s.size()-1; j >i; j--) {
                if (s.get(i).equals(s.get(j))) {
                    s.remove(j);
                }
            }
        }
    }

    /* private static void removal(List<Student> s,Student a) {
         for (int i = 0; i < s.size(); i++) {
             if(!s.get(i).repeat(a)){
                 s.add(a);
             }
         }
     }

 }*/
    static class Student {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
   /* public boolean repeat(Student s){
        if(this.hashCode() == s.hashCode()){
            return  true;
        }else {
            if(this.equals(s)){
                return true;
            }else {
                return false;
            }

        }
    }*/

