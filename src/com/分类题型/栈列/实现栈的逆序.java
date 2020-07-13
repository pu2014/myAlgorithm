package com.分类题型.栈列;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @DESC 空间复杂度为o(1) 实现栈的逆序
 * @CREATE BY @Author pbj on @Date 2020/7/13 22:08
 */
public class 实现栈的逆序 {
    private static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            stack.push(sc.nextInt());
        }
        reverse(stack);
        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        System.out.println(res);
    }

    private static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int stackTop = stack.pop();
        reverse(stack);
        stack.push(stackTop);
    }
}
