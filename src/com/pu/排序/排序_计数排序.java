package com.pu.排序;

import java.util.Arrays;
/*
    稳定性：稳定
    时间复杂度 O（N+K)
    空间复杂度：
 */

public class 排序_计数排序 {
    public static void main(String[] args) {
        int[] arr = createArr(10);
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bucketSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] - min]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0){
                arr[i++] = j;
            }
        }
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
