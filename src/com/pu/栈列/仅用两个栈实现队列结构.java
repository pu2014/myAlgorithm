package com.pu.栈列;

import java.util.Stack;

/**
    仅用两个栈实现队列结构

 */
public class 仅用两个栈实现队列结构 {
    public static class twoStackQueue{
        private Stack<Integer> stack;
        private Stack<Integer> help;

        public twoStackQueue(){
            stack = new Stack<>();
            help = new Stack<>();
        }
        public int peek(){
            if(stack.isEmpty()){
                throw new RuntimeException("the queue is empty!");
            }
            exchange(stack,help);
//            while(!stack.isEmpty()){
//                help.push(stack.pop());
//            }
            int dst = help.peek();
            exchange(help,stack);
//            while (!help.isEmpty()){
//                stack.push(help.pop());
//            }
            return dst;

        }
        public void push(int newNum){
            stack.push(newNum);

        }
        public int poll(){
            if(stack.isEmpty()){
                throw new RuntimeException("the queue is empty!");
            }
            exchange(stack,help);
//            while(!stack.isEmpty()){
//                help.push(stack.pop());
//            }
            int dst = help.pop();
            exchange(help,stack);
//            while (!help.isEmpty()){
//                stack.push(help.pop());
//            }
            return dst;
        }
        public boolean isEmpty(){
            return stack.isEmpty();
        }
        public int size(){
            return stack.size();
        }
        private void exchange(Stack s1,Stack s2){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
    }

    public static void main(String[] args) {
        twoStackQueue tq = new twoStackQueue();
        tq.push(453);
        tq.push(4233);
        tq.push(45);
        System.out.println(tq.peek());
        System.out.println(tq.poll());
        System.out.println(tq.poll());
        System.out.println(tq.poll());
        System.out.println(tq.size());
        System.out.println(tq.isEmpty());

    }

}
