package com.tools;

/**
 * 利用数组的实现(小根堆）
 */
public class MinHeap{
    private int size;
    private Integer [] array;

    public MinHeap(int initSize){
        this.size = 0;
        array =  new Integer[initSize];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void add(Integer element){
        if(size >= array.length - 1){
            return;
        }else{
            array[size++] = element;
            swim(size - 1);  // up
        }
    }

    private void swim(int i) {
        while(i > 0 && array[i] < array[(i - 1) >> 1]){
            swap(array,i,i>>1);
            i = (i - 1) >> 1;
        }
    }

    private void sink(int i) {
        int left = i * 2 + 1;
        int right = left + 1;
        while(left < size){
            int largest = right < size && array[right] < array[left] ? right : left;
            largest = array[largest] < array[i] ? largest : i;
            if(largest == i){
                break;
            }
            swap(array,i,largest);
            i = largest;
            left = i * 2 + 1;
            right = left + 1;
        }
    }

    public Integer peek(){
        return array[0];
    }

    public Integer poll(){
        Integer tmp = array[0];
        swap(array,0,size - 1);
        array[--size] = null;
        sink(0);            //down
        return tmp;

    }


    public void swap(Integer[] array,int i,int j){
        Integer tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        MinHeap mh = new MinHeap(20);
        mh.add(34);
        mh.add(43);
        mh.add(42);
        mh.add(41);
        System.out.println(mh.size());
        System.out.println(mh.peek());
        System.out.println(mh.poll());
        System.out.println(mh.poll());
        System.out.println(mh.poll());
        System.out.println(mh.poll());
        System.out.println(mh.isEmpty());
    }
}