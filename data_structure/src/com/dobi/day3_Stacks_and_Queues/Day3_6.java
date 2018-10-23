package com.dobi.day3_Stacks_and_Queues;


/**
 * 循环队列
 */
public class Day3_6 {

    public static void main(String[] args) {

        //为什么会有循环队列
        //就是因为普通的数组队列出队的时间复杂度是O(n)，每次出队后面的元素都要向前移动

        //循环队列出队后面的元素就不用都移动了，只需要将front的指向右移1位

        //当队列为空时，front == tail 都指向同一个位置
        //当队列不为空时，front指向第一个元素，tail指向最后一个元素的后面一位，就是要+1

        //队列满了的情况  tail+1 = front
        //改进后  (tail+1)%c = front
        //所以满了不能让tail和front重叠，故意浪费了一个空间






    }

}
