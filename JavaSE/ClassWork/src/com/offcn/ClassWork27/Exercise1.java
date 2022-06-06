package com.offcn.ClassWork27;
/*1、获取主方法所在的线程的名称
2、获取垃圾回收线程的线程名称*/
public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        new Rubbish();
        System.gc();

    }
}
class Rubbish{
    @Override
    protected void finalize() throws Throwable {
        System.out.println(Thread.currentThread().getName());
    }
}

