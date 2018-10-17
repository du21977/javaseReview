package com.dobi.day2_Arrays;

/**
 *   数组在java中的使用
 */
public class Day2_1 {

    public static void main(String[] args) {

        //使用方法一------先声明后赋值
        int[] arr= new int[10];
        for (int i = 0;i<arr.length;i++){
            arr[i] = i;
        }

        //使用方法二 --------声明并赋值
        int[] scores = new int[]{10,60,90,100};
        for (int i = 0;i<scores.length;i++){
            System.out.println(scores[i]);
        }

        //使用方法三 ---方法二简化版-----声明并赋值
        int[] scores_1 = {10,60,90,100};
        for (int i = 0;i<scores_1.length;i++){
            System.out.println(scores[i]);
        }

        scores[0] = 100;
        //使用foreach遍历
        for (int i: scores) {
            System.out.println(i);
        }





    }

}
