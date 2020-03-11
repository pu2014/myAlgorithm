package com.pu.优先级队列_堆实现;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目
 *  有一个源源不断的吐出整数的数据流，假设你有足够的空间来保存吐出的数，请设计一个名叫
 *  MedianHolder的结构，MedianHolder可以随时取得之前吐出所有数的中位数。
 *
 *  要求：
 *  1:如果MedianHolder已经保存了吐出的N个数，那么任意时刻将一个新数加入到MedianHolder
 *  的过程，其时间复杂度为O(logN)
 *  2:取得已经吐出的N个数整体的中位数的过程，时间复杂度为O(1)
 *
 *  解决办法：
 *  双堆解决（大根堆和小根堆）
 */

public class 随时找到数据流中的中位数 {
    static PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> bigHeap = new PriorityQueue<>((o1, o2)->o2 - o1);
    /*//升序排列
    public static class numComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }*/

    public static void main(String[] args){
        int[] arr= {2,3,4,5,6,3,2,4,7,8,1};
        for(int i = 0;i < arr.length;i++) {
            System.out.println(getMedianNumAdd(arr[i]));
        }
}

    public static int getMedianNumAdd(int num){
        if(bigHeap.size() == 0){
            bigHeap.add(num);
            return bigHeap.peek();
        }else{
            if(bigHeap.peek() >= num){
                bigHeap.add(num);
            }else{
                smallHeap.add(num);
            }
            while(bigHeap.size() - smallHeap.size() > 1){
                smallHeap.add(bigHeap.poll());
            }
            while(smallHeap.size() - bigHeap.size() > 1){
                bigHeap.add(smallHeap.poll());
            }
            if(smallHeap.size() - bigHeap.size() > 0){
                return smallHeap.peek();
            }else{
                return bigHeap.peek();
            }
        }


    }

}
