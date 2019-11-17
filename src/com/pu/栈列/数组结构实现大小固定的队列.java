package com.pu.栈列;

public class 数组结构实现大小固定的队列 {
    public static class Queue{
        private Integer[] arr;
        private Integer start;
        private Integer end;
        private Integer size;
        public Queue(int initsize) {
            if(initsize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initsize];
            start = 0;
            end = 0;
            size = 0;
        }
        public Integer peek(){
            if(size == 0){
                return null;
            }
            return arr[start];
        }
        public void push(int obj){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[end] = obj;
            end = end == arr.length - 1 ? 0: end + 1;

        }
        public Integer poll(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }

        public int nextIndex(int size,int index){
            return index == size - 1 ? 0 : index + 1;
        }

    }
    public static void main(String[] args) {
        Queue que = new Queue(3);
        que.push(8);
        que.push(9);
        que.push(10);
        System.out.println(que.peek());
        que.push(11);
        System.out.println(que.size);

    }

}


