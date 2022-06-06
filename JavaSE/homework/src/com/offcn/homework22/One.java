package com.offcn.homework22;

/*       慢         快
* 、比较ArrayList和LinkedList在头部增删元素的效率
*
* */




public class One {
    public static void main(String[] args) {
        LinkStack<String> list1 =new LinkStack();
        ArrayStack<String> list2 =new ArrayStack<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list1.push("sufbu");
//            System.out.println(list1.pop());
        }
        list1.print();
        long end = System.currentTimeMillis();
        System.out.println("linkedlist所用时间"+(end-start));

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {

            list2.push("iuhuftr");
        }
        long end1 = System.currentTimeMillis();
        list2.print();
        System.out.println("arraylist所用时间"+(end1-start1));


    }



}
