package com.pu.栈列;

import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度
 */
//todo  错误代码
public class 最长的包含有效括号的子串的长度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s == null || s == ""){
            System.out.println(0);
        }
        int max = 0;
        int count = 0;
        int index = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i) == ')' && stack.peek() == '('){
                    if(i == index + 2 || i == index + 1){
                        count += 2;
                    }else{
                        count = 2;
                    }
                    max = Math.max(count, max);
                    index = i;
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        System.out.println(max);
    }
}
