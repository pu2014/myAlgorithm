package com.tools;

import java.util.ArrayList;

public class Queue<E> {
        private ArrayList<E> arr;
        private int start;
        private int end;
        private int size;

        public Queue() {
            arr = new ArrayList<E>();
            start = 0;
            end = 0;
            size = 0;
        }

        public E peek() {
            if (size == 0) {
                return null;
            }
            return arr.get(start);
        }

        public void offer(E e) {
            size++;
            arr.add(e);
            end++;
        }

        public E poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = start;
            start++;
            return arr.get(tmp);
        }
        public boolean isEmpty(){
            if(size == 0){
                return true;
            }else
                return false;
        }
        public int size(){
            return size;
        }
    }
