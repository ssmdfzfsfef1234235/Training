package com.offcn.homework22;

import java.util.LinkedList;

public class LinkStack<E>{
    private LinkedList<E> list = new LinkedList<E>();

    //头部增
    public void push(E a) {
        list.addFirst(a);
    }

    //头部删
    public E pop() {
        return list.removeFirst();
    }

    public int length() {
        return list.size();
    }
    public  void print(){

        System.out.println(list.toString());

    }
    public Object get(E a) {
        if (list.contains((E) a)) {
            for (Object o : list) {
                if (a.equals(o)) {
                    return o;
                }
            }
        }

        return null;
    }
}
