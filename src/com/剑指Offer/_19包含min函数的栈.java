package com.剑指Offer;


import java.util.Stack;

/**
 * description：
 * 两个栈实现max min
 * @author Pubojian
 * @date 2020/3/11 11:24
 */
public class _19包含min函数的栈 {
    public static void main(String[] args) {
        int[] nums = {3,2,4,1,5};
        MMStack mms = new MMStack();
        for(int num : nums){
            mms.push(num);
            System.out.println(mms.min() + "--" + mms.max());
        }
    }
}
class MMStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()) minStack.push(node);
        else minStack.push(node < minStack.peek() ? node : minStack.peek());
        if(maxStack.isEmpty()) maxStack.push(node);
        else maxStack.push(node > maxStack.peek() ? node : maxStack.peek());
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        maxStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
    public int max(){
        return maxStack.peek();
    }
}
