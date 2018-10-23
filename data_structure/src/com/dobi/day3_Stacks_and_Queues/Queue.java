package com.dobi.day3_Stacks_and_Queues;

/**
 * 队列接口
 * @param <E>
 */
public interface Queue<E> {
    void enqueue(E e);  //  入队
    E dequeue()  ;//出队
    E  getFront();//  拿到队首元素
    int getSize();//  队列中元素的大小
    boolean isEmpty() ;// 队列是否为空

}
