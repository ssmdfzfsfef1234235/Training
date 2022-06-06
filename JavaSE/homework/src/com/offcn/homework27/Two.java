package com.offcn.homework27;
/*2、同时开启3个线程，共同输出100~200之间的所有数字，并且在输出奇数的时候将线程名称打印出来
 */
public class Two {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 100; i < 201; i++) {
                        if (i % 2 != 0) {
                            System.out.println(Thread.currentThread().getName()+"---"+i);

                        }
                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable, "线程1");
        Thread thread2 = new Thread(runnable, "线程2");
        Thread thread3 = new Thread(runnable, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
