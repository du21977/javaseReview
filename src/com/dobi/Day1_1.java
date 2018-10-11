package com.dobi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 第一个程序
 * 两个快捷键--psvm和sout分别是public static void main和 System.out.println的快捷键
 */
public class Day1_1 {
    public static void main(String[] args) {
        System.out.println("-----------");

        int a = 5;
        String ab = "aaaaa";  //该变量指向了对象，字符串是引用类型

        /**
         * java的基本数据类型
         * 整数：byte(1字节8位，java中整型是带符号的，byte是-128到127)  int(4字节32位)  short（2字节16位）   long(8字节)
         * 浮点：float  double
         * 布尔类型：boolen
         * 字符型：char
         *
         * 8位二进制范围：00000000-11111111（0-255）
         */

        int i1 = 2000;
        int i2 = 0xff0000; //16进制
        int i3 = 0b1000; //二进制

        final  int i4 = 666; //常量

        //异或运算 相同为0，不同为1

        char A = 'A';
        int i = A;
        System.out.println(i); //输出65，说明A的ASII码是65


        //字符类型是基本类型，而字符串类型是引用类型
        //基本类型的变量是持有某个数值
        //引用类型是指向某个对象


        //数组类型(引用类型)  查看大小.length
        int[] n = new int[5];
        n[0]=666;

        int[] m = {0,1,2};
        System.out.println(m[1]);

        int[] p = new int[]{66,99,77,88};  //简写成上面
        //快速打印数组中的内容----
        System.out.println(Arrays.toString(p));
        //排序----SDK内部对大数组用的是快排，对小数组用的是冒泡排序
        Arrays.sort(p);
        System.out.println(Arrays.toString(p));

        //二维数组
        int[][] aaa1 = {
                {1,2,3},
                {4,5,6}
        };
        //打印
        System.out.println(Arrays.toString(aaa1[0]));//打印一维数组
        System.out.println(Arrays.toString(aaa1));//每个一维数组的地址
        System.out.println(Arrays.deepToString(aaa1));//打印每个二维数组的元素


        //输出
        System.out.println(); //换行输出
        System.out.print("");
        System.out.printf("%d\n",6); //格式化输出

        //输入
       // Scanner


        //浮点数==判断不靠谱，，可以用差值小于某个值来判断
        // Math.abs(x-0.1)<0.0001

        //引用类型的判断
        String s1 = "hello";
        String s2 = "hello";
        if(s1==s2){  //==判断是否指向同一个对象
            System.out.println("指向同一个对象"); //会输出
        }
        if(s1.equals(s2)){  //equals判断内容是否相等
            System.out.println("内容一样"); //也会输出
        }

        //引用类型的判断
        String s3 = "hello";
        String s4 = "HELLO".toLowerCase();
        if(s3==s4){  //==判断是否指向同一个对象
            System.out.println("指向同一个对象");  //不输出，证明不指向同一个对象
        }
        if(s3.equals(s4)){  //equals判断内容是否相等
            System.out.println("内容一样");//输出
        }

        //switch可以整型匹配，也可以字符串匹配，或者枚举类型，不能是浮点型
        switch (a){
            case 1:
                break;
            case 2:
                break;
             default:
                 break;
        }

        //for循环建议将int写在for里面，因为这样i8变量的作用域只属于for循环
        for(int i8 =0;i<9;i++){

        }

        //foreach循环---可遍历数组，list,map-----速度更快
        int[] ns ={10,20,30,40};
        for (int nn: ns) {
            System.out.println(nn);
        }


        //break 直接结束离他最近的循环体
        //continue 可提前结束当前循环

        int aaa = 6;
        if(a==6){
            for(int sss=0;sss<3;sss++){
                break;
            }

            System.out.println("break--test");//在if中的居然不执行了
        }
        System.out.println("break--test-----");//执行


        for(int sss=0;sss<3;sss++){
            if(sss==1){
                break;
            }
            System.out.println("break--test--555");//执行
        }
        System.out.println("break--test--666");//执行
    }
}
