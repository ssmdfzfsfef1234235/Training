package com.offcn.homework19;


import java.util.Arrays;
import java.util.Scanner;

/*
*写一个方法判断一个字符串是否对称，要求：要用到StringBuilder
 */
class Symmetric{
    public static void main(String[] args) {
        System.out.println(Symmetric.isSymmetric("bsfcyvse"));
        System.out.println(Symmetric.isSymmetric("abccba"));


    }
    public static boolean isSymmetric(String s) {

        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println(stringBuilder);
         String st=stringBuilder.reverse().toString();
        System.out.println(st);

        if(s.equals(st)){
            return true;
        }else {
            return false;
        }

    }


}
/*
键盘录入一个字符串，统计该字符串中的大写字母、小写字母、数字字符和其他字符分别有多少个
例如，键盘录入abcABCD12345!@#$%&，输出结果为：小写字母有3个，大写字母有4个，数字字符有5个，其他字符有6个。
*/

class Count{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        Count.count(next);

    }
    public static void count(String s){
        int upper = 0 , lower = 0 , number = 0 ,other = 0 ;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                upper ++;
            }else  if(chars[i] >= 'a' && chars[i] <= 'z'){
                lower ++;
            }else if(chars[i] >= '0' && chars[i] <= '9'){
                number ++;
            }else {
                other ++;
            }
        }
        System.out.println("小写字母有"+lower+"个，大写字母有"+upper+"个，数字字符有"+number+"个，其他字符有"+other+"个");
    }
}
/*
* 键盘录入一个正整数n，创建一个大小为n的数组
   键盘录入m（m <= n）个整数，存入上述数组，
   当录入字符串"end"或者录入个数达到n时，结束录入
   并且将数组内容、数组最大值按照指定格式进行输出
	例如：
		请录入数组大小：
		10
		请录入若干整数
		2
		4
		5
		6
		7
		end
		最终结果为：[2, 4, 5, 6, 7, 0, 0, 0, 0, 0], 最大值为7
   提示：如果录入的数字是String类型的，即"123"，通过 Integer.parseInt("123")，
	 即可将"123"变为int类型的123
	 * */
class Array{

    public static void main(String[] args) {

        int i = getI();

        int[] array = Array.createArray(i);

        array = add(array);

        printArray(array);

    }

    private static void printArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder("[");

        int max = 0 ;

        for (int j = 0; j < array.length; j++) {

            if(max < array[j]){

                max = array[j];

            }

            stringBuilder.append( new Integer(array[j]).toString());

            stringBuilder.append(j == array.length - 1 ? "" : ",");

        }
        stringBuilder.append("]");

        System.out.println("最终结果为："+stringBuilder.toString()+", 最大值为"+max);
    }

    private static int[] add(int[] array) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请录入若干整数");

        for (int j = 0; j < array.length; j++) {

            String next = scanner.nextLine();

            if(next.equals("end")){

                break;
            }

            int i1 = Integer.parseInt(next);

            array[j] =i1;

        }

        System.out.println(array);

        return array;
    }

    private static int getI() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请录入数组大小：");

        String next = scanner.next();

        Integer integer = new Integer(next);

        return integer.intValue();
    }

    public static int[] createArray(int a){

        int[] ints = new int[a];

        return ints;
    }
}
/*结合Arrays工具类中学过的方法：
生成1-100内的n个不重复的随机数（n需要键盘录入），之后存入合适的数组，最终输出
数组中第一、第二、第三大的元素。
*/
class Random{
    public static void main(String[] args) {
        int i = getI();

        int[] array = Array.createArray(i);

        array=add(array);

        Arrays.sort(array);

        System.out.println(Arrays.toString(array));
    }

    private static int[] add( int[] array) {
        int  max1 = 0,max2 = 0 ,max3 = 0;

        for (int j = 0; j < array.length; j++) {

            int random = (int)(Math.random()*99+1);

            while ( isRepeat(array,j,random)){
                random = (int)(Math.random()*99+1);
            }

            array[j]=random;

            if(max1 < array[j]){
                max1 = array [j] ;
            }

            if (array[j] > max2 && array[j] != max1) {
                max2 = array[j];
            }

            if (array[j] > max3 && array[j] != max1 && array[j] != max2) {
                max3 = array[j];
            }

        }

        System.out.println("数组中第一大的元素"+max1+"、第二大的元素"+max2+"、第三大的元素"+max3+"。");

        return array;
    }

    private static boolean isRepeat(int a[],int j,int random){
        for (int i = 0; i <= j; i++) {

            if(  random == a[i] ){

            return  true;
            }
        }
        return false;

    }

    private static int getI() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请录入数组大小：");

        String next = scanner.next();

        Integer integer = new Integer(next);

        return integer.intValue();
    }

    public static int[] createArray(int a){

        int[] ints = new int[a];

        return ints;
    }


}
public class HomeWork {
    /*String、StringBuilder和StringBuffer的区别
    * 1、String拼接字符串步骤：
    * （1）先将传入的数据转为String类型
    * （2）通过调用StringBuilder构造方法创建StringBuilder对象（第一次创建对象）
    * （3）将需要拼接字符串的数据填入已经创建好的StringBuilder对象中
    * （4）通过调用String类型的构造方法，将StringBuilder对象转为String类型的对象 （第二次创建对象）
    *  2、StringBuilder拼接字符串的步骤：
    * （1）创建Stringbuilder对象（第一次创建对象）
    * （2）将需要拼接字符串的数据通过append方法填入穿件好的StringBuilder对象当中
    * （3）将已经填写完毕数据的StringBuilder对象，通过toString方法转为String类型的 对象（第二次创建对象）
    * 3、总结： String类型的加号拼串，一个加号就需要创建两个对象，如果多次进行加号拼串，非常 浪费时间和空间资源，
    * 想对而言不推荐使用加号拼串 StringBuilder拼串，不论拼接多少次，都只需要两个对象，相对加号拼串而言，效率较 高，
    * 并且节约系统资源
    * StringBuffer和StringBuilder的区别
    *  1、共同点： 都是字符串的缓冲区，都是字符串的生成器，都是可变的字符序列
    * 2、不同点： （1）出现版本不同： StringBuffer在jdk1.0出现的 StringBuilder在jdk1.5出现的
    * （2）线程安全性不同： StringBuffer是线程安全的，在多线程环境下仍然保证数据安全 StringBuilder是线程不安全，在多线程环境下无法保证数据安全
    * （3）效率不同： StringBuffer效率低StringBuilder效率高*/
}
