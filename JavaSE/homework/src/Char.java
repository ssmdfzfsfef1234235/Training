import java.util.Scanner;

/*
* 键盘录入一个大小写混杂的纯英文字符串
将字符串转换成首字母大写，其他字母全部小写
例如，键盘录入”i lOvE jAvA”，转换成 “I love java”
* */
public class Char {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("录入一个大小写混杂的纯英文字符串");
        String str = sc.nextLine();

        String string =str.toLowerCase();
        System.out.println(string);
        String str1 = string.substring(0,1).toUpperCase();

        String str2 = string.substring(1,string.length());
        string = str1.concat(str2);
        System.out.println(string);
//        char[] ch = string.toCharArray();
//        ch[0]-=32;
//        for (int i = 0; i < ch.length; i++) {
//            System.out.print(ch[i]);
//        }



    }

}
