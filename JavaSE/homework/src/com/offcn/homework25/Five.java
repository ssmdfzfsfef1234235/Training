package com.offcn.homework25;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/*字符流题目：获取一个文本上每个字符出现的次数,将结果写在times.txt上*/
public class Five {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("homework\\src\\com\\offcn\\homework25\\test");
        FileWriter fw = new FileWriter("homework\\src\\com\\offcn\\homework25\\times.txt");
        HashMap<String, Integer> ch = new HashMap<>();
        int i;


        while ((i = fr.read()) != -1) {
            char c= (char)i;
            String str = String.valueOf(c);
             if (str.equals("\n")){
                    str ="\\n";
             }else if (str.equals("\t")){
                 str ="\\t";
             }else if (str.equals(" ")){
                 str ="space";
             }else if (str.equals("\r")){
                 str ="\\r";
             }
            ch.put(str, ch.containsKey(str) ? ch.get(str) + 1 : 1);
            for (String character : ch.keySet()) {
                fw.write(character+":"+ch.get(character));
                System.out.println(character + ":" + ch.get(character));

                 }
        }

        fr.close();
        fw.close();
        System.out.println(ch);

    }

}
