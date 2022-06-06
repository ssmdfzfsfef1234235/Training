package com.offcn.ClassWork19;
/*
* 定义一个方法，接收一个int[]类型的数组，返回该数组的字符串表示形式
举例：接收数组为int[] arr = {1, 2, 3}，返回的字符串为[1, 2, 3]
要求：使用StringBuilder进行拼接，提高运行效率
* */
public class Exercise {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        String string = toString(arr);
        System.out.println(string);

    }
    public static String toString(int[] a){
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            stringBuilder.append(a[i]).append(i==a.length-1?"":",");

        }
        stringBuilder.append("]");
        String string = stringBuilder.toString();
        return string;

    }
}
