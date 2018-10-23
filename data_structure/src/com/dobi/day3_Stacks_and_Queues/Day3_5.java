package com.dobi.day3_Stacks_and_Queues;

/**
 * 数组队列
 */
public class Day3_5 {

    public static void main(String[] args) {

        //队列
        //队列也是一种线性结构
        //相比数组，队列对应的操作也是数组的子集
        //只能从一端添加数据，只能从另一端取出数据

        //队列是一种先进先出的数据结构(先到先得FIFO)

        //队列所拥有的方法
        //Queue<E>
        //void enqueue(E)  入队
        //E dequeue()  出队
        //E  getFront()  拿到队首元素
        //int getSize()  队列中元素的大小
        //boolean isEmpty()  队列是否为空


        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i =0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue.toString());

            if(i%3==2){
                queue.dequeue();
                System.out.println(queue.toString());
            }
        }





    }


    static  class ArrayQueue<E> implements  Queue<E>{

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


}
