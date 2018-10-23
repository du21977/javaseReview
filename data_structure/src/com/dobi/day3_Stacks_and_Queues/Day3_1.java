package com.dobi.day3_Stacks_and_Queues;

/**
 * 栈和栈的应用：撤销操作和系统栈
 */
public class Day3_1 {

    public static void main(String[] args) {

        //栈也是一种线性结构
        //相比数组，栈对应的操作是数组的子集
        //只能从一端添加元素，也只能从一端取出元素
        //这一端称为栈顶

        //栈是一种后进先出的数据结构
        //Last In First Out(LIFO)

        //栈的应用
        //很多软件(如word)的撤销操作，
        //程序调用的系统栈---函数中子函数的操作

        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        for (int i = 0;i<5;i++){
            arrayStack.push(i);
            System.out.println(arrayStack.toString());
        }

        arrayStack.pop();
        System.out.println(arrayStack.toString());


    }


    /**
     * 用数组实现栈
     * @param <E>
     */
   static  class  ArrayStack<E> implements  Stack<E>{

       Array<E> array ;

       //无参构造函数
       public ArrayStack(){
           array = new Array<>();
       }

       //有参构造函数
       public ArrayStack(int capacity){
           array = new Array<>(capacity);
       }

        @Override
       public int getSize() {
           return array.getSize();
       }

       public int getCapacity(){
           return getCapacity();
       }

       @Override
       public boolean isEmpty() {
           return array.isEmpty();
       }

       @Override
       public void push(E e) {

           array.addLast(e);
       }

       @Override
       public E pop() {
           return array.removeLast();
       }

       @Override
       public E peek() {
           return array.getLast();
       }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            res.append("Stack");
            res.append('[');
            for (int i =0;i<array.getSize();i++){
                res.append(array.get(i));
                if(i != array.getSize()-1){
                    res.append(", ");
                }
            }
            res.append(']');
            res.append(" top");//尾部是栈顶
            return res.toString();
        }
   }


}
