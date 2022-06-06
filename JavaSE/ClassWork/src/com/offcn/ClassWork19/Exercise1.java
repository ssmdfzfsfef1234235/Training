package com.offcn.ClassWork19;

public class Exercise1 {
    public static void main(String[] args) {
        test1();
        test2();

    }

    private static void test2() {
        String s = new String();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s += "a";

        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间为"+(end - start));
    }

    private static void test1() {
        StringBuilder stringBuilder = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append("a");

        }
        long end = System.currentTimeMillis();
        System.out.println("花费时间为"+(end - start));
    }


}
