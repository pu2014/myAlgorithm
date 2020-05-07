package com.分类题型.栈列;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能上再实现返回栈中最小元素的操作
 * 要求： pop push getMin的时间复杂度都为O(1)
 *       设计的栈类型可以使用现成的栈结构
 *
 */

public class 返回栈中最小元素 {
    public static void main(String[] args) {
        minStack ms = new minStack();
        ms.push(99);
        ms.push(49);
        ms.push(39);
        ms.push(65);
        System.out.println(ms.getmin());
    }
    public static class minStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public  minStack(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        private void push(int data){
            if(this.stackMin.isEmpty()){
                this.stackMin.push(data);
            }else if(data < this.getmin()){
                this.stackMin.push(data);
            }else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
            this.stackData.push(data);
        }

        private int pop(){
            if(this.stackData.isEmpty()){
                throw new IllegalArgumentException("The stack is empty");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

        private int getmin(){
            if(stackMin.isEmpty()){
                throw new IllegalArgumentException("The stack is empty");
            }
            return this.stackMin.peek();
        }
    }
}
