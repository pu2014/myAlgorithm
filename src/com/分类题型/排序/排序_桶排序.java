package com.分类题型.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 不同桶类调用其他方法
 *
 * O（N + M)
 *
 * 桶越多越快
 */

public class 排序_桶排序 {
    public static void main(String[] args){
        int[] arr = createArr(10);
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bucketSort(int[] arr) {
        int min = getArrMin(arr);
        int max = getArrMax(arr);
        int len = (max -min)/10 + 1;
        ArrayList<LinkedList<Integer>> bucket = new ArrayList<>(len);
        for(int i = 0; i < len; i++){
            bucket.add(new LinkedList<Integer>());
        }
        enterBucket(arr,bucket,min,len);
        for(LinkedList<Integer> ll:bucket){
            Collections.sort(ll);
        }
        outBucket(arr,bucket);

    }

    private static void outBucket(int[] arr, ArrayList<LinkedList<Integer>> bucket) {
        int index = 0;
        for(LinkedList<Integer> ll:bucket){
            for(Integer i : ll){
                arr[index++] = i;
            }
        }
    }

    private static void enterBucket(int[] arr, ArrayList<LinkedList<Integer>> bucket,int min,int len) {
        for(int i = 0; i < arr.length; i++){
            bucket.get((arr[i] - min) / 10).add(arr[i]);
        }
    }

    private static int getArrMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }

    private static int getArrMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i = 0;i <arr.length;i++){
            min = Math.min(min,arr[i]);
        }
        return min;
    }

    private static int[] createArr(int n) {
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = (int)(Math.random() * 100);  // 0.0-0.99 包括0
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
