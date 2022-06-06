package com.offcn.homework27;
/*1、有一辆班车除司机外只能承载80个人，假设前中后三个车门都能上车，如果坐满则不能再上车。
   请用线程模拟上车过程并且在控制台打印出是从哪个车门上车以及剩下的座位数。
   比如:
  	（前门上车---还剩N个座...）*/
public class One {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            int i = 80;

            @Override
            public   void  run() {
                while (true){
                   synchronized (this){
                       if (i==0){
                           break;
                       }
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println(Thread.currentThread() + "上车---还剩" + (i--) + "个座...）");
                   }
                }
            }
        };
        Thread thread1 = new Thread(runnable,"前门");
        Thread thread2 = new Thread(runnable,"中门");
        Thread thread3 = new Thread(runnable,"后门");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
