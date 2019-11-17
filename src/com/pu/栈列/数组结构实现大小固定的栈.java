package com.pu.栈列;

public class 数组结构实现大小固定的栈 {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(3);
        as.push(2);
        as.push(3);
        as.push(4);
        System.out.println(as.peek());
        System.out.println(as.pop());
        System.out.println(as.size);

    }
    public static class ArrayStack{
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize){
            if(initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
        }


        public Integer peek(){
            if(size == 0){
                return null;
            }
            return arr[size - 1];
        }

        public void push(int obj){
            if(size == arr.length){
                throw new IndexOutOfBoundsException("The stack is full");
            }
            arr[size++] = obj;
        }

        public Integer pop(){
            if(size == 0){
                throw new IndexOutOfBoundsException("The stack is empty");
            }
            return arr[--size];
        }
    }
}
