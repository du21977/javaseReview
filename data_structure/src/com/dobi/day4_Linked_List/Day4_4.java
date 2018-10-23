package com.dobi.day4_Linked_List;

/**
 * 链表的遍历，查询，修改
 */
public class Day4_4 {

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

        private Node dummyHead; //虚拟头节点
        int size;
        public LinkedList(){
            dummyHead = new Node(null,null);  //即使是空链表，也有一个节点，即虚拟头节点
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
//            Node node = new Node(e);
//            node.next = head;
//            head = node;
//            //head = new Node(e,head); //这句话代表了上面三句话
//            size++;

            add(0,e);
        }

        //在链表的index(包含0)位置添加新的元素e
        //在链表操作中不常用，主要是练习和面试考思维用
        public void add(int index,E e){
            if(index <0 || index>size){
                throw new IllegalArgumentException("add failed .. Illegal index");
            }


            //找到要插入元素的前一个节点
            Node prev = dummyHead;
            for (int i = 0 ;i<index;i++){
                prev = prev.next;
            }
            //要插入的节点
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            // prev.next = new Node(e,prev.next);//相当于上面三行代码
            size++;


        }

        //在链表末尾添加新的元素e
        public void addLast(E e){
            add(size,e);
        }


    }

}
