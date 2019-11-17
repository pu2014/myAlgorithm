package com.tools;

public class Stack {
        private Integer[] arr;
        private Integer size;

        public Stack(int initSize){
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
