package com.笔试.shopee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @DESC  3, 2, 5, 3, 7, 19, 20
 * @CREATE BY @Author pbj on @Date 2020/9/16 16:06
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        line = line.replace(" ", "");
        int[] nums = Arrays.stream(line.split(",")).mapToInt(Integer::valueOf).toArray();
        int heapSize = nums.length/2 + 1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapSize);
        for(int i=0; i<heapSize; i++){
            heap.add(nums[i]);
        }
        for(int i=heapSize; i<nums.length; i++){
            if(heap.peek() < nums[i]){
                heap.poll();
                heap.add(nums[i]);
            }
        }
        if(nums.length % 2 == 1){
            System.out.println(heap.peek());
        }
        else{
            System.out.println((heap.poll()+heap.peek())/2.0);
        }
    }
}
