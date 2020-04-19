package com.剑指Offer;

import com.tools.Node;

import java.util.Stack;

/**
 * description：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * O(n1)
 * @author Pubojian
 * @date 2020/2/24 18:58
 */
public class _05用两个栈实现队列 {
    public static void main(String[] args) {

        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        MyQueue<Node> mq = new MyQueue<Node>();
        mq.push(node1);
        mq.push(node2);
        System.out.println(mq.pop().val);
        mq.push(node3);
        System.out.println(mq.pop().val);


    }
}
class MyQueue<T>{
    private Stack<T> s1 = new Stack<>();
    private Stack<T> s2 = new Stack<>();
    //stack1 进入
    public void push(T t){
        s1.push(t);
    }
    //stack2 为空，需要返回stack1的最大值，所以需要将stack1移到stack2，取得前面的值
    //stack2 不为空， 直接返回栈顶元素即可
    public T pop(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

}

