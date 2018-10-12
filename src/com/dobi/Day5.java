package com.dobi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合
 */
public class Day5 {
    public static void main(String[] args) {

        //Collection类  包含List和 Set
            //List 是一种有序的列表
            //Set 是一种保证没有重复元素的集合
        //Map 一种通过Key查找Value的映射表集合

        //遗留类---不应该使用了
        //Hashtable---一种线程安全的Map实现
        //Vector -----一种线程安全的List实现
        //Stack ------基于Vector实现的LIFO的栈

        //java的集合使用统一的Iterator集合

       //foreach内部实际上是转换成了iterator来遍历


        List<String> list = new ArrayList<>();
        list.add("hello li");
        list.add("hello mei")

        //Map集合
        Map<String,Object> map = new HashMap<>();
        map.put("1","haha");
        map.put("2","hehe");
        for (String key: map.keySet()) {
            Object o = map.get(key);
            System.out.println(o);
        }


    }


}
