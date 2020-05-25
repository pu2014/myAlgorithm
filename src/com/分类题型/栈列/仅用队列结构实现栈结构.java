package com.分类题型.栈列;
import com.tools.Queue;

/**
 * 仅用队列结构实现栈结构
 *
 * 提示：双队列实现
 */

public class 仅用队列结构实现栈结构 {
    public static class twoQueueStack{
        private Queue<Integer> firstQueue;
        private Queue<Integer> secondQueue;

        public twoQueueStack() {
            firstQueue = new Queue<Integer>();
            secondQueue = new Queue<Integer>();
        }
        public void push(int pushInt){
            firstQueue.offer(pushInt);
        }
        public int pop(){
            if(firstQueue.isEmpty()){
                throw new RuntimeException("Stack is empty!");
            }
            while(firstQueue.size() != 1){
                secondQueue.offer(firstQueue.poll());
            }
            int res = firstQueue.poll();
            swap();
            return res;
        }

        public int peek(){
            if(firstQueue.isEmpty()){
                throw new RuntimeException("Stack is empty！");
            }
            while(firstQueue.size() > 1){
                secondQueue.offer(firstQueue.poll());
            }
            int res = firstQueue.poll();
            secondQueue.offer(res);
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = firstQueue;
            firstQueue = secondQueue;
            secondQueue = tmp;
        }
    }

    public static void main(String[] args) {
        twoQueueStack ts = new twoQueueStack();
        ts.push(34);
        ts.push(35);
        ts.push(33);
        System.out.println(ts.peek());
        System.out.println(ts.pop());
        System.out.println(ts.peek());
    }

}
