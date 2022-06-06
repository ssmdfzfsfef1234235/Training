package com.offcn.ClassWork25;
/*
生兔子的问题（假设所有兔子都不会死）
第一个月有1对兔子，到了第三个月会生出一对新兔子，新生的兔子到了第三个月又会生一对新兔子，每一对兔子开始生之后，
都会保持每个月生一对新兔子
问：第十个月新老兔子一共有多少对

*/
public class ClassWork25 {
    public static void main(String[] args) {
        System.out.println(fac(10));
    }

    private static int fac(int n) {
       if (n<=2){
           return 1;
       }else {
           return fac(n-1)+fac(n-2);
       }
    }
}
