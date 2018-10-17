package com.dobi.day2_Arrays;

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

        //数组的优点：快速查询
        Array array = new Array();
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

        //获取index索引位置
        public int get(int index){
            if(index<0 ||index >=size){
                throw new IllegalArgumentException("Get failed. Index is illegal");
            }
            return data[index];
        }

        //修改指定位置的元素
        public void set(int index ,int e){
            if(index<0 ||index >=size){
                throw new IllegalArgumentException("Get failed. Index is illegal");
            }
            data[index] = e;
        }

        //数组中是否包含某个元素
        public boolean contains(int e){
            for (int i = 0;i<size;i++){
                if(data[i]==e){
                    return true;
                }

            }
            return false;
        }

        //查找元素在数组中的索引，如果不存在就返回-1
        public int find(int e){
            for (int i = 0;i<size;i++){
                if(data[i]==e){
                    return i;
                }
            }
            return -1;
        }

        //从数组中删除index位置的元素，返回删除的元素
        public int remove(int index){
            if(index<0 ||index >=size){
                throw new IllegalArgumentException("Get failed. Index is illegal");
            }
            int ret = data[index];
            for (int i=index;i<size-1;i++){
                data[i] = data[i+1];
            }
            size--;
            return ret;
        }

        //删除索引位置为0的元素
        public int removeFirst(){
            return  remove(0);
        }

        //删除数组中最后一个元素
        public int removeLast(){
            return remove(size-1);
        }

        //删除指定的元素
        public void removeElement(int e){
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



