package com.dobi.day2_Arrays;

import com.dobi.day2_Arrays.bean.Student;

import java.util.ArrayList;

/**
 * 基于java中的数组，二次封装属于我们的数组
 * 动态数组---有增删改查的功能
 *
 * 2_3向数组中添加元素
 *
 * 2_4向数组中查询和修改元素
 *
 * 2-5数组中的包含，搜索和删除元素
 * 2-6使用泛型
 */
public class Day2_6 {

    public static void main(String[] args) {

       //泛型的作用是我们的数据结构放置各种类型
        //但是不能放置基本类型，只能放在类对象
        //8种基本类型：byte,char,boolean,short,int ,long,float,double
        //每个基本类型对应相应的包装类

        Array<Integer> array = new Array<>();
        array.addLast(0);
        array.addLast(1);
        System.out.println(array.toString());
        System.out.println(array);

        array.addFirst(99);
        System.out.println(array);

        array.add(2,66);
        System.out.println(array);

        array.contains(66);

        array.remove(0);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        array.removeElement(66);
        System.out.println(array);

        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student("du",55));
        studentArray.addLast(new Student("ducheng",99));
        System.out.println(studentArray);

    }




    static class Array<E>{

        private  E[] data;
        private int size;  //数组中元素的个数

        //有参构造函数
        public Array(int capacity){
            //不支持new泛型类型对象，需要new Object然后强转成泛型
            //data = new E[capacity];
            data = (E[]) new Object[capacity];

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
        public void addLast(E e){
//            if(size == data.length){
//                throw new IllegalArgumentException("AddLast failed. Array is full");
//            }
//            data[size] = e;
//            size++;

            //这个代替上面的代码
            add(size,e);

        }

        //向数组第一个位置添加一个元素
        public void addFirst(E e){
            add(0,e);
        }

        //向数组指定的位置插入一个元素，第index个元素
        public void  add(int index,E e){
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

        //获取index索引位置
        public E get(int index){
            if(index<0 ||index >=size){
                throw new IllegalArgumentException("Get failed. Index is illegal");
            }
            return data[index];
        }

        //修改指定位置的元素
        public void set(int index ,E e){
            if(index<0 ||index >=size){
                throw new IllegalArgumentException("Get failed. Index is illegal");
            }
            data[index] = e;
        }

        //数组中是否包含某个元素
        public boolean contains(E e){
            for (int i = 0;i<size;i++){
                if(data[i].equals(e)){
                    return true;
                }

            }
            return false;
        }

        //查找元素在数组中的索引，如果不存在就返回-1
        public int find(E e){
            for (int i = 0;i<size;i++){
                if(data[i].equals(e)){
                    return i;
                }
            }
            return -1;
        }

        //从数组中删除index位置的元素，返回删除的元素
        public E remove(int index){
            if(index<0 ||index >=size){
                throw new IllegalArgumentException("Get failed. Index is illegal");
            }
            E ret = data[index];
            for (int i=index;i<size-1;i++){
                data[i] = data[i+1];
            }
            size--;
            data[size]=null;  //防止内存泄漏
            return ret;
        }

        //删除索引位置为0的元素
        public E removeFirst(){
            return  remove(0);
        }

        //删除数组中最后一个元素
        public E removeLast(){
            return remove(size-1);
        }

        //删除指定的元素
        public void removeElement(E e){
            int index = find(e);
            if(index!=-1){
                remove(index);
            }
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            res.append(String.format("数组元素个数size = %d, 数组容量capacity = %d\n",size,data.length));
            res.append('[');
            for (int i =0;i<size;i++){
                res.append(data[i]);
                if(i != size-1){
                    res.append(", ");
                }
            }
            res.append(']');
            return res.toString();
        }


    }

}


