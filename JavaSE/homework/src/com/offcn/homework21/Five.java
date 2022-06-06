package com.offcn.homework21;

import java.util.ArrayList;
import java.util.List;

/*分析以下需求，并用代码实现：
	(1)生成10个1至100之间的随机整数(不能重复)，存入一个Collection集合
	(2)编写方法对Collection集合进行排序（排序操作：1、可以在帮助手册的Collections类中寻找；2、使用冒泡排序；此题排序用两种方式实现）
	(2)然后利用迭代器遍历集合元素并输出
	(3)如：15 18 20 40 46 60 65 70 75 91*/
public class Five {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<Integer>();

        while (integers.size()<10){

            int i = (int) (Math.random() * 99 + 1);
            int m=0;
            for (int j = 0; j < integers.size() - 1; j++) {
                if(integers.get(j).equals(i)){
                    m++;
                }
            }
            if(m==0){
                integers.add(i);
            }
        }
        System.out.println(integers);
        System.out.println(Five.bubbleSort(integers));
    }
    public static List<Integer> bubbleSort(List<Integer> e){
        for (int i = 0; i < e.size()-1; i++) {
            Integer tem;
            for (int j = 0; j < e.size()-1-i; j++) {
                if(e.get(j)>e.get(j+1)){
                    tem = e.get(j);
                    e.set(j,e.get(j+1));
                    e.set(j+1,tem);
                }
            }
        }
        return e;

    }


}