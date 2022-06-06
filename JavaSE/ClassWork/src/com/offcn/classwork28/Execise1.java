package com.offcn.classwork28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*1、有两个List集合，存储队伍中的多个成员姓名，使用Stream方式，对以下步骤进行操作
1、第一个队伍只要名字为3个字的成员姓名
2、第一个队伍只要筛选之后的前三个人

3、第二个队伍只要姓张的
4、第二个队伍筛选之后不要前两个人

5、将两个队伍合并成一个队伍
6、合并之后的队伍中的所有人的Person（自定义类型）对象，存储到一个ArrayList集合中

队伍1：宫本武藏、宋公明、苏有朋、石头人、时传祥、李耳、庄子、洪七公
队伍2：帕瓦罗蒂、张三疯、赵薇薇、张自忠、孛儿只斤铁木真、张天爱、张翠花*/
public class Execise1 {
    public static void main(String[] args) {
       String str1="宫本武藏、宋公明、苏有朋、石头人、时传祥、李耳、庄子、洪七公";
       String str2="帕瓦罗蒂、张三疯、赵薇薇、张自忠、孛儿只斤铁木真、张天爱、张翠花";

        String[] split1 = str1.split("、");
        String[] split2 = str2.split("、");

        List<String> strings1 = Arrays.asList(split1);
        List<String> strings2 = Arrays.asList(split2);
//        第一个队伍只要名字为3个字的成员姓名
//        2、第一个队伍只要筛选之后的前三个人
        strings1.stream().filter(x->x.length()==3).limit(3).forEach(System.out::println);

//        3、第二个队伍只要姓张的
//        4、第二个队伍筛选之后不要前两个人
        strings2.stream().filter(x->x.startsWith("张")).skip(2).forEach(System.out::println);
//
//        5、将两个队伍合并成一个队伍
//        6、合并之后的队伍中的所有人的Person（自定义类型）对象，存储到一个ArrayList集合中
        Stream<String> concat = Stream.concat(strings1.stream(), strings2.stream());
        ArrayList<Person> people = new ArrayList<>();

        concat.map(Person::new).forEach(people::add);
        System.out.println(people);

    }
}
class Person{
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
