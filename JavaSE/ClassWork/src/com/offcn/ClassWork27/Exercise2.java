package com.offcn.ClassWork27;
/*分别从【作用上】和【代码】上：判断垃圾回收线程是否是守护线程*/
public class Exercise2 {
    public static void main(String[] args) {
        while (true){

            new Garbage();
        }



    }
}
class Garbage{
    @Override
    protected void finalize() throws Throwable {
        System.out.println(Thread.currentThread().isDaemon());
    }
}
