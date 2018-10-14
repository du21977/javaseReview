package com.dobi;

import java.util.*;

/**
 * 集合
 */
public class Day5 {
    public static void main(String[] args) {

        //Collection类  包含List和 Set
            //List 是一种有序的列表 ----------------ArrayList ----LinkList
            //Set 是一种保证没有重复元素的集合   ----HashSet()无序 和  TreeSet有序
        //Map 一种通过Key查找Value的映射表集合   -----HashMap()无序 和 TreeMap有序

        //遗留类---不应该使用了
        //Hashtable---一种线程安全的Map实现
        //Vector -----一种线程安全的List实现
        //Stack ------基于Vector实现的LIFO的栈

        //java的集合使用统一的Iterator集合

       //foreach内部实际上是转换成了iterator来遍历



        List<String> list = new ArrayList<>();
        list.add("hello li");
        list.add("hello mei");
        for (String s : list){
            System.out.println(s);
        }

        Set<String> set = new HashSet<>();//无序
        Set<String> set1 = new TreeSet<>();//有序
        set.add("666");
        set.add("777");
        for(String s : set){
            System.out.println(s);
        }


  ////////////////////////////////////////////////////////////下面是Map////////////////////////////////////////////////////////////////////////////////

        //Map集合 ---常用的是HashMap---是无序的
        Map<String,Object> map = new HashMap<>();
        map.put("1","haha");
        map.put("2","hehe");
        //遍历Key可以使用foreach循环keySet()
        for (String key: map.keySet()) {
            Object o = map.get(key);
            System.out.println(o);
        }
        //同时遍历Key和Value可以使用foreach循环遍历entrySet()
        for (Map.Entry<String,Object> entry: map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
        }


        //有序的Map ----TreeMap-----是以key的顺序排序
        Map<String,Object> treeMap = new TreeMap<>();
        treeMap.put("orange",2);
        treeMap.put("apple",3);
        treeMap.put("banana",1);
        for(String key:treeMap.keySet()){
            System.out.println(key);  //会输出apple,banana,orange
        }

        //HashMap通过计算Key的hashCode()定位Key的存储位置，继而获得Value
        //如果两个对象相等，那么他们的hashCode一定相等
        //a.equals(b) == true,则a.hashCode() == b.hashCode()
        //a.equals(b) == false,则a.hashCode() 和 b.hashCode()尽量不要相等，不然会引起冲突，这就是数据结构中要解决的hash冲突的问题，就要找一个好一点的hash函数
        //总结：hashCode相等的不一定是同一个对象，hashCode（）不相等的一定不是同一个对象

        //hashMap的原理----
        //先比较对象的hashcode，将不同的hashCode放在一个数组中，如果再遇到相同的hashCode,再根据比较对象的equals，如果相等，就不做处理，如果不相等，证明不是同一个对象，
        //说明hash冲突了，就要放入链表中了


    ///////////////////////////////////////////////////////下面是Queue队列/////////////////////////////////////////////////////////////////////////


  ///////////////////////////////////////////////////////下面是Stack栈/////////////////////////////////////////////////////////////////////////



    }


}
