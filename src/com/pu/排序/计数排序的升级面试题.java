package com.pu.排序;

import java.util.Arrays;

/**
 *  给定一个long类型可以正负数的数组，无序，如果排序之后相邻两数的最大差值是多少请返回
 *  时间复杂度要求 O(n)
 *
 *  思路：由时间复杂度只能往复杂度o(n)靠
 *      将数据按max-min均分为n+1份
 *      必有一份桶中无元素
 */

public class 计数排序的升级面试题 {
    public static void main(String[] args) {
        int[] arr = createArr(9);
        System.out.println(process(arr));
    }
    private static int process(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = arr.length;
        for (int i = 0; i < len ; i++) {
            if(arr[i] > max)
                max = arr[i];
            if(arr[i] < min)
                min = arr[i];
        }
        if(max == min)
            return 0;
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i],len,min,max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid],arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (;i <= len;i++){
            if(hasNum[i]){
                res = Math.max(res,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;

    }

    private static int bucket(int num, int len, int min, int max) {
        return (num - min) * len / (max - min);
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
