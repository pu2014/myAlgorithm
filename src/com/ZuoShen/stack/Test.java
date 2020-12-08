package com.ZuoShen.stack;


import java.util.Iterator;
import java.util.Stack;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/12/8 15:18
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        Iterator it = stack.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
