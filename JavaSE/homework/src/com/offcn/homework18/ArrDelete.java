package com.offcn.homework18;

public class ArrDelete {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        int b[] =  ArrDelete.Delete(a, 3);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
    public static int[] Delete(int a[],int index){
        for (int i = index; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1]=0;

        return a;
    }
}
/*
* 1、（略微难）编写一个方法，能够删除一个int[]数组中的指定位置元素。指定的位置通过索引来表示
* */
