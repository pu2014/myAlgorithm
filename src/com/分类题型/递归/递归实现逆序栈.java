package com.分类题型.递归;

import java.util.Stack;

/**
 * 给你一个栈，请你逆序这个栈，
 * 不能申请额外的数据结构，只能使用递归函数
 * 1：将栈的栈底元素返回并移除
 * 2：逆序一个栈。
 */
public class 递归实现逆序栈 {
    public static void main(String[] args){
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(2);
        test.push(3);
        while(!test.isEmpty()){
            System.out.println(test.pop());
        }
    }
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int res = stack.pop();
        if(stack.isEmpty()){
            return res;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(res);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
