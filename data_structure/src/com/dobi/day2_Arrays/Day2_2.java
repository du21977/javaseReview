package com.dobi.day2_Arrays;

/**
 * 基于java中的数组，二次封装属于我们的数组
 * 动态数组---有增删改查的功能
 */
public class Day2_2 {

    public static void main(String[] args) {

        //数组的优点：快速查询

    }



}


class Array{

    private  int[] data;
    private int size;  //数组中元素的个数

    //有参构造函数
    public Array(int capacity){
        data = new int[capacity];
        size =0;
    }

    //无参构造函数
    public Array(){
        this(10); //调用有一个参数的构造函数
    }

    //获取数组中元素的个数
    public int  getSize(){

        return size;
    }

    //获取数组的容量
    public int getCapacity(){

        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }



}
