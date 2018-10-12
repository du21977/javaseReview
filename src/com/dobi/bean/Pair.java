package com.dobi.bean;

/**
 * day4中编写泛型
 */
/*
public class Pair {

    private T First;
    private T last;


    public Pair(T first, T last) {
        First = first;
        this.last = last;
    }

    public T getFirst() {
        return First;
    }

    public T getLast() {
        return last;
    }
}*/


//Pair<T> 申明类型T
public class Pair<T> {

    private T First;
    private T last;


    public Pair(T first, T last) {
        First = first;
        this.last = last;
    }

    public T getFirst() {
        return First;
    }

    public T getLast() {
        return last;
    }


}
