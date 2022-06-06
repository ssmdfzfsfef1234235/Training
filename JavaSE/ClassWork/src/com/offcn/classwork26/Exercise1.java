package com.offcn.classwork26;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*键盘录入一个文件路径，将该文件反转
反转：第一行变成最后一行，第二行变成倒数第二行
记得：使用流的时候，一定遵循晚创建早关闭的原则*/
public class Exercise1 {
    public static void main(String[] args) throws IOException {
        File out = getDir();
//E:\IDEA\CODE\JavaSE\homework\src\com\offcn\homework25
        BufferedReader br = new BufferedReader(new FileReader("homework\\src\\com\\offcn\\homework25\\test"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(out));
        ArrayList<String> strings = new ArrayList<>();
        String read;
        if ((read = br.readLine())!= null){
            strings.add(read);
        }
        Collections.reverse(strings);
        bw.write(String.valueOf(strings));

        br.close();
        bw.close();


    }
    static File getDir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("键盘录入一个文件路径，将该文件反转");
        String s = scanner.nextLine();

        File file = new File(s);
        if (file.isFile()){
            return file;
        }else {
            System.out.println("请输入合法文件路径");
        }
        return file;
    }
}
