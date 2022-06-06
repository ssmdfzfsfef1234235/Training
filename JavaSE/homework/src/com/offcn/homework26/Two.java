package com.offcn.homework26;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/*2、按要求完成：
（1）创建一个学生类，有姓名、年龄属性
（2）创建一个配置文件，文件里记录了5组学生的姓名和年龄，文件内容例如：
	name1=zhangsan
	age1=23
	name2=lisi
	age2=24
	......
（3）通过加载配置文件，读取到配置文件中记录的姓名和年龄，根据读取到的姓名、年龄，创建5个学生对象。
（3）读取到不正确的年龄时，直接通过抛出自定义异常（IllegalAgeException，年龄非法异常）打断对象创建
（4）自定义异常要定义成编译时异常
（5）在创建对象的时候要使用JDK7之前的关流格式对对象的创建进行处理
（6）如果没有出现异常，则继续将学生对象进行序列化，存储到名为instance.txt的文件中。
（7）再对学生类中添加一个属性：成绩
（8）将已经序列化的学生对象读取回来，通过键盘录入的形式，为学生对象添加成绩属性值
（9）最后将学生对象打印到控制台，显示学生对象的所有属性值
*/
public class Two {
    public static void main(String[] args) throws IOException, AgeException, ClassNotFoundException {
        ArrayList<Student> students = getStudents();

        outPut(students);
        ArrayList<Student> list = inPut();
        System.out.println(list);
        Scanner scanner = new Scanner(System.in);
        for (Student student : list) {
            System.out.println("请输入学生分数：");
            String s = scanner.nextLine();
            student.setScore(Integer.parseInt(s));
            System.out.println(student);
        }


    }

    /**
     * 反序列化
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */

    private static ArrayList<Student> inPut() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("homework\\src\\com\\offcn\\homework26\\instance.txt"));
        ArrayList<Student> list = (ArrayList) ois.readObject();
        ois.close();
        return list;
    }

    /**
     * //从配置文件读入student并创建student对象写入队列
     * @return
     * @throws IOException
     * @throws AgeException
     */

    private static ArrayList<Student> getStudents() throws IOException, AgeException {
        Properties p = new Properties();
        p.load(new FileInputStream("homework\\src\\com\\offcn\\homework26\\config.properties"));

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            String name = p.getProperty("name" + i);
            String age = p.getProperty("age" + i);
            students.add(new Student(name, Integer.parseInt(age)));
        }
        return students;
    }

    /**
     * 序列化
     * @param students
     * @throws IOException
     */

    private static void outPut(ArrayList<Student> students) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("homework\\src\\com\\offcn\\homework26\\instance.txt"));
        oos.writeObject(students);
        oos.close();
    }


}
class Student implements Serializable {
    private static final long serialVersionUID = -7876921652585950134L;
//    public static final long Serializable=1L;

    String name;
    int age;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    int score;

    public Student(String name, int age, int score) throws AgeException {
        this.name = name;
        setAge(age);
        this.score = score;
    }

    public Student() {
    }

    public Student(String name, int age) throws AgeException {
        this.name = name;
         setAge(age);
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

    public void setAge(int age) throws AgeException {
        if (age>0&&age<120){

            this.age = age;
        }else {
            throw new AgeException("请输入正确年龄");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
class AgeException extends Exception{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }

    public AgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgeException(Throwable cause) {
        super(cause);
    }

    protected AgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}