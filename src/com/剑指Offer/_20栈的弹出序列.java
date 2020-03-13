package com.剑指Offer;

import java.util.Stack;

/**
 * description：栈的压入、弹出序列
 *输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈
 * 的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺
 * 序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等
 * @author Pubojian
 * @date 2020/3/12 9:04
 */
public class _20栈的弹出序列 {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 1, 2, 3};
        System.out.println(new IsPopOrder().method(pushA, popA));
    }

}
class IsPopOrder {
    public boolean method(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0 || popA.length != pushA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}