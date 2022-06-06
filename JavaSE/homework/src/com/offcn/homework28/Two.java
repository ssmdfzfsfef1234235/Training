package com.offcn.homework28;
/*使用switch语句结合枚举类型，以枚举项作为匹配的表达式，输出打印周一到周日*/
public class Two {
    public static void main(String[] args) {
        Week[] values = Week.values();
        for (Week value : values) {
            switch (value){
                case FRI:
                    System.out.println("今天是周五");break;
                case MON:
                    System.out.println("今天是周一");break;
                case TEU:
                    System.out.println("今天是周二");break;
                case THUR:
                    System.out.println("今天是周四");break;
                case WED:
                    System.out.println("今天是周三");break;
                case SUN:
                    System.out.println("今天是周日");break;
                case SATU:
                    System.out.println("今天是周六");break;

            }
        }

    }
}
enum  Week{
    MON,TEU,WED,THUR,FRI,SUN,SATU;
}
