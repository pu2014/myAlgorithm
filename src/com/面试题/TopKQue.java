package com.面试题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @DESC topk问题
 * @CREATE BY @Author pbj on @Date 2020/8/16 13:51
 */
public class TopKQue {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 11, 12, 15, 4, 7, 8, 9, 10};
        System.out.println(getTopKByPriorityQueue(nums, 5));
        System.out.println(getTopByHeap(nums, 5));
        System.out.println(getTopByPartition(nums, 5));

    }

    /**
     * 基于partition来做，时间复杂度o(n)
     * //会修改数组
     * @param nums
     * @param k
     * @return
     */
    private static List<Integer> getTopByPartition(int[] nums, int k) {
        if(nums == null || nums.length < k){
            return new ArrayList<>();
        }
        partitionHelper(nums, k, 0, nums.length - 1);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(nums[i]);
        }
        return res;
    }

    private static void partitionHelper(int[] nums, int k, int left, int right) {
        if(left < right){
            int[] inxs = partition(nums, left, right);
            if(k < inxs[0]){
                partitionHelper(nums, k - left, left, inxs[0] - 1);
            }else if(k > inxs[1]){
                partitionHelper(nums, k - inxs[1], inxs[1] + 1, right);
            }else{
                return;
            }
        }
    }

    private static int[] partition(int[] nums, int left, int right) {
        int i = left;
        int piovt = nums[left];
        while(i <= right){
            if(nums[i] < piovt){
                swap(nums, i++, left++);
            }else if(nums[i] > piovt){
                swap(nums, i, right--);
            }else{
                i++;
            }
        }
        return new int[]{left, right};
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 采用堆排序，如果求最小的k个数，那就用大根堆
     * 采用优先级队列
     * @param nums
     * @param k
     */
    public static List<Integer> getTopKByPriorityQueue(int[] nums, int k){
        if(nums == null || nums.length < k){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i = 0; i < k; i++){
            priorityQueue.add(nums[i]);
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] < priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        return new ArrayList<>(priorityQueue);
    }

    /**
     * 自己建立大根堆
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> getTopByHeap(int[] nums, int k){
        if(nums == null || nums.length < k){
            return new ArrayList<>();
        }
        Integer[] heap = new Integer[k];
        for(int i = 0; i < k; i++){
            heap[i] = nums[i];
        }
        for(int i = k / 2; i >= 0; i--){
            heapify(heap, i);
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] < heap[0]){
                heap[0] = nums[i];
                heapify(heap, 0);
            }
        }
        return Arrays.asList(heap);
    }

    private static void heapify(Integer[] heap, int i) {
        int cur = i;
        int left = cur * 2 + 1;
        int right = left + 1;
        while(left < heap.length){
            int maxIndex = right < heap.length ? heap[left] < heap[right] ? right : left : left;
            if(heap[maxIndex] > heap[cur]){
                int temp = heap[maxIndex];
                heap[maxIndex] = heap[cur];
                heap[cur] = temp;
            }
            cur = maxIndex;
            left = cur * 2 + 1;
            right = left + 1;
        }
    }


}
