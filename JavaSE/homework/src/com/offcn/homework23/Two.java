package com.offcn.homework23;

import java.util.*;

/*2、分析以下需求，并用代码实现：
	(1)定义一个学生类Student，包含属性：姓名(String name)、年龄(int age)
	(2)定义Map集合，用Student对象作为key，用字符串(此表示表示学生的住址)作为value
	(3)利用四种方式遍历Map集合中的内容，格式：key::value
	*/
public class Two {
    public static void main(String[] args) {
        Map<Student, String> hs = new HashMap<>();
        hs.put(new Student("打比赛",24),"市WF4WAF松");
        hs.put(new Student("wevgsWWAGFT",24),"W案发当晚轻松");
        hs.put(new Student("W工时费",24),"市深V发生的松");
        hs.put(new Student("匪我愆期3",24),"市说的VCAV炽热松");
        hs.put(new Student("A FR 4F",24),"市谁发出去而发松");
        System.out.println(hs);
//        iter1(hs);
//        iter2(hs);
        iter3(hs);
        iter4(hs);

    }

    private static void iter4(Map<Student, String> hs) {
        Iterator<Map.Entry<Student, String>> iterator = hs.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Student, String> next = iterator.next();
            System.out.println(next);
        }
    }

    private static void iter3(Map<Student, String> hs) {
        Set<Map.Entry<Student, String>> entries = hs.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            System.out.println(entry.getKey()+"::"+entry.getValue());
        }
    }

    private static void iter2(Map<Student, String> hs) {
        Iterator<Student> iterator = hs.keySet().iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next+"::"+hs.get( next));
        }
    }

    private static void iter1(Map<Student, String> hs) {
        for (Student student : hs.keySet()) {
            System.out.println(student+"::"+hs.get(student));
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