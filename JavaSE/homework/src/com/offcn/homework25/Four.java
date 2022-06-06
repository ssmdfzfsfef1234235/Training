package com.offcn.homework25;

import java.io.*;

/*4、（难度都在路径上）键盘录入一个文件夹路径，作为源文件夹，这个文件夹还嵌套了文件夹；
键盘录入一个文件夹路径，将其作为目标文件夹写代码将源文件夹拷贝到目标文件夹中
	a
	b
	b/a*/
public class Four {
    public static void main(String[] args) throws IOException {
        File input = One.getDir();
        File output = One.getDir();
        copy(input, output);
    }

    private static void copy(File input, File output) throws IOException {
        File[] files = input.listFiles();
        for (File file : files) {
            String[] i1 = file.getName().split("\\\\");
            if (file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(output+"/"+ i1[i1.length-1]);
                byte[] i= new byte[8192];
                if (fileInputStream.read(i)!=-1){
                    fileOutputStream.write(i);
                }
                fileInputStream.close();
                fileOutputStream.close();
            }else {
                File file1 = new File(output + "/" + i1[i1.length - 1]);
                file1.mkdir();
                copy(file,file1);
            }
        }

    }
}
