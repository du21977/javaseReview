package com.dobi.day3_Stacks_and_Queues;

/**
 *
 */
/**
 * 用数组实现栈  day3_1
 * @param <E>
 */
public   class  ArrayStack<E> implements  Stack<E>{

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
