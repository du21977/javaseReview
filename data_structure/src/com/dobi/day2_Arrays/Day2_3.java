package com.dobi.day2_Arrays;

/**
 * 基于java中的数组，二次封装属于我们的数组
 * 动态数组---有增删改查的功能
 *
 * 2_3向数组中添加元素
 */
public class Day2_3 {

    public static void main(String[] args) {

        //数组的优点：快速查询

        Array array = new Array();
        array.addLast(0);
        array.addLast(1);

    }




    static class Array{

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

        //向数组中添加一个新元素，在数组末尾即所有元素后面添加
        public void addLast(int e){
//            if(size == data.length){
//                throw new IllegalArgumentException("AddLast failed. Array is full");
//            }
//            data[size] = e;
//            size++;

            //这个代替上面的代码
            add(size,e);

        }

        //向数组第一个位置添加一个元素
        public void addFirst(int e){
            add(0,e);
        }

        //向数组指定的位置插入一个元素，第index个元素
        public void  add(int index,int e){
            if(size == data.length){
                throw new IllegalArgumentException("AddLast failed. Array is full");
            }

            if(index<0 ||index >size){
                throw new IllegalArgumentException("Add failed. Required index >=0 and index <=size");
            }

            for (int i = size-1;i>=index;i--){
                data[i+1] = data[i] ;
            }

            data[index] = e;
            size++;

        }


    }

}



