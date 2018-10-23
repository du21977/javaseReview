package com.dobi.day3_Stacks_and_Queues;

/**
 * 栈的接口
 * @param <E>
 */
public interface Stack<E> {

    //

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();  //取栈顶元素

}
