package com.分类题型.优先级队列_堆实现;

import java.util.PriorityQueue;

/**
 * 一块金条切成两半，是需要花费和长度数值一样的铜板，比如长度为20的金条，
 * 不管切成长度多大两半，都要花费20个铜板，一群人想分整块金条，如何分最省铜板
 *
 * 给定【10，20,30】 代表3个人，整块金条长度为60
 * 输出 90
 *
 * 思想：哈弗曼编码
 *      贪心算法
 */
public class 金条切两半花费铜板问题 {
    public static void main(String[] args){
        int[] arr = {10,20,40,50,30};
        System.out.println(getTheMinCost(arr));
    }

    private static int getTheMinCost(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0;i < arr.length;i++){
            heap.add(arr[i]);
        }
        int dst = 0;
        while(heap.size() > 1){
            int tmp = heap.poll() + heap.poll();
            dst += tmp;
            heap.add(tmp);
        }
        return dst;
    }
}
