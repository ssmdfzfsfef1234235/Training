package com.offcn.homework18;
/*分析以下需求，并用代码实现：
	(1)定义数字字符串数组{"010","3223","666","7890987","123123"}
	(2)判断该数字字符串数组中的数字字符串是否是对称(第一个数字和最后一个数字相等，第二个数字和倒数第二个数字是相等的，依次类推)的，并逐个输出
	(3)如：010 是对称的，3223 是对称的，123123 不是对称的
	(4)最终打印该数组中对称字符串的个数
	提示：循环获取字符串的每一个字符，依次比较第一个和最后一个，第二个和倒数第二个。。。

*/
public class Symmetric {
    public static void main(String[] args) {
        String[] ints = {"010","3223","666","7890987","123123"};
        Symmetric.judgeSymmetry(ints);

    }
    public static void judgeSymmetry(String[] a){
        /*int count=0;
        for (int i = 0; i < a.length  ; i++) {
            if(a[i].equals(a[a.length - 1-i])){
                System.out.println(a[i] + "是对称的");
                count++;
            }else {
                System.out.println(a[i] + "是不对称的");
            }

        }
        System.out.println(count);*/
    }
}
