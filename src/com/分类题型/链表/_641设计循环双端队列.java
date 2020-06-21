package com.分类题型.链表;

/**
 * @DESC 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/6/21 19:19
 */
public class _641设计循环双端队列 {
    /**
     * 浪费一个位置判断
     * 1.数组大小是给定大小+1，因为rear所指向的位置始终是空的 2.末尾插入要先赋值再移动rear指针 3.队满和队空的条件
     */
    class MyCircularDeque {

        int[] nums;
        int max;
        int head;
        int tail;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            max = k + 1;
            nums = new int[max];
            head = 0;
            tail = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull()){
                return false;
            }
            head = (head - 1 + max) % max;
            nums[head] = value;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(isFull()){
                return false;
            }
            nums[tail] = value;
            tail = (tail + 1) % max;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(isEmpty()){
                return false;
            }
            head = (head + 1) % max;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(isEmpty()){
                return false;
            }
            tail = (tail - 1 + max) % max;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if(isEmpty()){
                return -1;
            }
            return nums[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if(isEmpty()){
                return -1;
            }
            return nums[(tail - 1 + max) % max];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return head == tail;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (tail + 1 + max) % max == head;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
