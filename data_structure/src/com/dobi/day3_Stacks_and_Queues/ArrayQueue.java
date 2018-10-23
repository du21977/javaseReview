package com.dobi.day3_Stacks_and_Queues;

/**
 * 数组实现队列 day3_5
 */
public   class ArrayQueue<E> implements  Queue<E>{

    private Array<E> array;

    //无参构造函数
    public ArrayQueue(){
        array = new Array<>();
    }
    //有参构造函数
    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue:");
        res.append("front[");//队头
        for (int i =0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize()-1){
                res.append(", ");
            }
        }
        res.append(']');
        res.append(" tail");//队尾
        return res.toString();
    }
}
