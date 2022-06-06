package com.offcn.stageone;
/*1、题目：封装一个Cale类，封装两个整数加、减、乘、除的方法并且返回结果，实现在main方法中调用; （25分）
1）Cale定义加方法（5分，作答时长5分钟）
2）Cale定义减方法 (5分，作答时长5分钟）
3）Cale定义乘方法 (5分，作答时长5分钟）
4）Cale定义除方法 (5分，作答时长5分钟）
5）在测试类调用方法 (5分，作答时长10分钟）*/
public class One {
    public static void main(String[] args) {
        Cale cale = new Cale(1, 3);
        System.out.println(cale.add(1, 3));
        System.out.println(cale.subtract(1, 3));
        System.out.println(cale.multiply(1, 3));
        System.out.println(cale.divide(1, 3));
    }
}
class Cale{
    int a,b;

    public Cale() {
    }

    public Cale(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Cale{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public static int add(int a, int b){
        return a+b;
    }
    public static int subtract(int a, int b){
        return a-b;
    }
    public static int multiply(int a, int b){
        return a*b;
    }
    public static int divide(int a, int b){
        return a/b;
    }
}