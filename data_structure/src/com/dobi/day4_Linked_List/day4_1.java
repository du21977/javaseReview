package com.dobi.day4_Linked_List;

/**
 * 什么是链表
 */
public class day4_1 {

    //前面学过的线性数据结构：动态数组，栈，队列
    //底层依赖的是静态数组，靠resize解决固定容量问题


    //链表---真正的动态数据结构---最简单的动态数据结构
    //数据存储在节点Node中,每个节点都包含下一个节点的信息
    /*
    class Node{
        E e;
        Node next;
    }*/

    //优点：真正的动态，没有容量的限制
    //缺点：丧失了随机访问的能力


    public static void main(String[] args) {

    }



    class LinkedList<E> {


        private class Node{
            public E e;
            public Node next;
            public Node(E e,Node next){
                this.e = e;
                this.next = next;
            }

            public Node(E e)  {
               this(e,null);
            }

            public Node()  {
                this(null,null);
            }

            @Override
            public String toString() {
                return e.toString();
            }
        }




    }



}
