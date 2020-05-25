package com.分类题型.栈列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/3/7 22:35
 */
public class 返回列中最大元素 {
    public static void main(String[] args) {
        MaxQueue mq = new MaxQueue();
        mq.push_back(2);
        mq.push_back(1);
        mq.push_back(4);
        mq.push_back(3);
        mq.push_back(1);
        System.out.println(mq.max_value());
        System.out.println(mq.pop_front());
        System.out.println(mq.pop_front());
        System.out.println(mq.max_value());
        System.out.println(mq.pop_front());
        System.out.println(mq.max_value());
        System.out.println(mq.pop_front());
        System.out.println(mq.max_value());
    }
}
class MaxQueue {
    private LinkedList<Integer> maxQueue;
    private Queue<Integer> queue;
    public MaxQueue() {
        maxQueue = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        return maxQueue.size() > 0 ? maxQueue.peek() : -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while(maxQueue.size() > 0 && maxQueue.peekLast() < value){
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        int tmp = queue.poll();
        if(maxQueue.size() > 0 && maxQueue.peek() == tmp){
            maxQueue.poll();
        }
        return tmp;
    }
}
