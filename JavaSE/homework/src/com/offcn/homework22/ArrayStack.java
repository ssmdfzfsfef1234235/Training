package com.offcn.homework22;

import java.util.ArrayList;

public class ArrayStack<E>{

    private ArrayList list =  new ArrayList<E>();

    public void push(E a) {
        list.add(0,a);
    }

    //头部删
    public E pop() {
        return (E) list.remove(0);
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