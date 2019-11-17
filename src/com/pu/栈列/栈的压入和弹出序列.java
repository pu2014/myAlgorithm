package com.pu.栈列;

import java.util.Stack;

/**
 * description：输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个
 * 弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * @author Pubojian
 * @date 2019/11/9 16:20
 */
public class 栈的压入和弹出序列 {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popB = {4,5,3,2,1};

        System.out.println(isPopOrder(pushA, popB));
    }

    private static boolean isPopOrder(int[] pushA, int[] popB) {
        while(pushA.length == 0 || popB.length == 0 || popB.length != pushA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int k = 0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popB[k]){
                stack.pop();
                k++;
            }
        }
        return stack.empty();
    }
}
