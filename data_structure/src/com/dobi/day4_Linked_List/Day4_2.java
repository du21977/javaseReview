package com.dobi.day4_Linked_List;

/**
 * 在链表中添加元素
 */
public class Day4_2 {

    public static void main(String[] args) {

        //在链表头添加元素
        //node.next = head
        //head = node

        //在链表中间添加元素
        //node为要添加的节点，pre为要添加节点的前一个节点
        //node.next = pre.next;
        //pre.next = node
        //关键是找到要添加节点的前一个节点


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

        private Node head;
        int size;
        public LinkedList(){
            head = null;
            size = 0;
        }

        //获取链表中的元素个数
        public int getSize(){
            return size;
        }

        //返回链表是否为空
        public boolean isEmpty(){
            return size == 0;
        }

        //在链表头添加新的元素
        public  void addFirst(E e){
            Node node = new Node(e);
            node.next = head;
            head = node;
            //head = new Node(e,head); //这句话代表了上面三句话
            size++;
        }


    }
}
