package com.dobi.day3_Stacks_and_Queues;

import java.util.Stack;

/**
 * 栈的另一个应用---括号的匹配
 * leetcode--第二十道题目
 */
public class Day3_3 {

    public static void main(String[] args) {

        //栈顶元素反应了在嵌套的层次关系中，最近的需要匹配的元素

       Solution solution =  new Solution() ;
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("()[}{}"));

//        System.out.println(solution.isValid("{}"));
    }


    /**
     * 判断是否是有效的字符串
     * @param
     * @return
     */
    static  class Solution{


        public boolean isValid(String s){
            //这里我们使用java提供的栈
            Stack<Character> stack = new Stack<>();
            for (int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c=='('||c=='['||c=='{'){
                    stack.push(c);
                }else {
                    if(stack.isEmpty()){
                        return false;
                    }
                    char pop = stack.pop();
                    if(c==')'&&pop!='('){
                        return false;
                    }
                    if(c==']'&&pop!='['){
                        return false;
                    }
                    if(c=='}'&&pop!='{'){
                        return false;
                    }
                }
                System.out.println(stack.toString());
            }
            System.out.println("---"+stack.toString());
            return stack.isEmpty();
        }
    }

}
