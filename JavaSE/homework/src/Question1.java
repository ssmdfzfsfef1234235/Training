public class Question1 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.highJump();
    }
}
/*
* 1、设计：
	动物类：姓名，年龄，吃饭，睡觉。
	猫类（捉老鼠）和狗类（看家）
	动物培训接口：跳高
	会跳高的猫
*/
class Animal{
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
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

    public void eat(){
        System.out.println("吃");

    }
    public void sleep(){
        System.out.println("睡");

    }
}
interface AnimalTraining {
    abstract void highJump();
}
class Cat extends Animal implements AnimalTraining{


    public void catchMice(){
        System.out.println("抓老鼠");

    }

    @Override
    public void highJump() {
        System.out.println("会跳高的猫");

    }
}
class Dog extends Animal implements AnimalTraining{


    public void watchHouse(){
        System.out.println("看家");

    }

    @Override
    public void highJump() {
        System.out.println("会跳高的狗");

    }
}