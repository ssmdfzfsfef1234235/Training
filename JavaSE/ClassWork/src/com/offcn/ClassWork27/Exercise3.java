package com.offcn.ClassWork27;
/*三个窗口，同时售卖100张火车票
打印某个窗口卖出了1张票，还剩x张*/
public class Exercise3 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            int i = 100;

            @Override
            public synchronized void run() {
                for (int j = 0; j < i; j++) {
                    System.out.println(Thread.currentThread().getName()+"-------"+i--);
                }
            }
        };
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r1);
        Thread thread3 = new Thread(r1);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
