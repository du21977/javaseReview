package com.dobi.day3_Stacks_and_Queues;

import java.util.Random;

/**
 * 数组队列和循环队列的比较
 * ArrayQueue time :3.771243042s
 * LoopQueue time :0.018807194s
 */
public class Day3_8 {

    public static void main(String[] args) {

        int opCount =100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue time :"+time+"s");


        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time1 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue time :"+time1+"s");

    }

    //测试入队和出队需要的时间s
    private static double testQueue(Queue<Integer>queue,int opCount){
        long startTime = System.nanoTime(); //单位是us纳秒

        Random random = new Random();
        for (int i=0;i<opCount;i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i=0;i<opCount;i++){
           queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime)/1000000000.0;
    }
}
