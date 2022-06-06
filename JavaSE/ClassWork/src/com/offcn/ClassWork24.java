package com.offcn;

import java.io.File;
import java.io.IOException;

/*在D盘下的a/b/c/d中创建一个文件，名称叫HelloWorld.txt
* */
/*键盘录入一个字符串，表示一个文件夹路径，如果不是文件夹路径则提示重新录入
打印当前文件夹下，所有的大于70M的后缀名是.mp4的文件的绝对路径
*/
public class ClassWork24 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:a/b/c/d");
        System.out.println(file.mkdirs());
        File file1 = new File(file,"HelloWorld.txt");
        file1.createNewFile();


    }
}
