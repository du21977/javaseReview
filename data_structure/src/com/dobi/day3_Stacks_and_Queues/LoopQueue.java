package com.dobi.day3_Stacks_and_Queues;

/**
 * 数组实现循环队列   day3_6_7
 */
public   class  LoopQueue<E> implements  Queue<E>{

    private E[] data;
    private  int front; //指向队头
    private int tail;  //指向队尾+1
    private int size; //元素的个数

    public LoopQueue(){
        this(10);  //调用有参构造函数
    }

    public LoopQueue(int capacity){
        //java中不能直接new泛型
        data = (E[]) new Object[capacity+1]; //因为循环队列需要浪费一个空间，所以需要+1
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity(){
        return data.length -1;     //因为浪费了一个空间
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {

        //如果队列满了，就得扩容
        if((tail +1)%data.length ==front){
            resize(2*getCapacity()); //扩容2倍
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空，不能出队");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        //进行缩容
        if(size == getCapacity()/4 &&getCapacity()/2 !=0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    /**
     * 队首的元素
     * @return
     */
    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }


    /**
     * 扩容
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity+1];  //要浪费一个空间
        for(int i = 0;i<size;i++){
            newData[i] = data[(i+front)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("队列元素个数size = %d, 队列容量capacity = %d\n",size,getCapacity()));
        res.append("front[");
        for (int i =front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if(i !=tail){
                res.append(", ");
            }
        }
        res.append("]tail");
        return res.toString();
    }
}
