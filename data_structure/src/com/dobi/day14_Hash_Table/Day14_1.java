package com.dobi.day14_Hash_Table;

/**
 * 哈希表基础
 */
public class Day14_1 {

    /**
     * 查找字符串中第一个不重复出现的元素
     * 假设都是小写字母，并且只有字母
     *
     * 这里是为了引出哈希函数
     * f(ch) = ch- 'a'
     * 是哈希函数
     *
     * 哈希函数：键转换为索引
     *
     * 现实生活中，很难保证每一个键通过哈希函数的转换对应不同的索引
     *
     * 如果通过哈希函数转换成了相同的索引，这就叫哈希冲突，也叫碰撞
     *
     * 问题：如何设计哈希函数，如何解决哈希冲突
     *
     * 哈希表的好处：用空间换时间，减少查找时间
     *
     */
    public int firstUniqChar(String s){
        int[] num = new int[26];//只有26个字母，存储每个字母出现的次数
        for (int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;    //将每个字母的ASII码减a作为索引  即index=ch - 'a'
        }
        for (int i=0;i<s.length();i++){
            if(num[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }


    ////////////////////////////////////////////////////////////////////////////





}
