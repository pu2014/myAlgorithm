package com.分类题型.排序;

import java.util.Arrays;

/**
 *    排序_冒泡排序
 *    时间复杂度        n + (n-1) + (n-2) +... = n(n-1)/2  O(n^2)
 *    空间复杂度         O(1)
 *    稳定性  稳定
 */
public class 排序_冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {23,5,67,8,9,97,4,3,42,45,35};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {23,5,67,8,9,97,4,3,42,45,35};
        bubbleSortOpt(arr1);
        System.out.println(Arrays.toString(arr));
    }

    //稳定的
    private static void bubbleSort(int[] arr) {
        if(arr.length < 2 || arr == null){
            return;
        }
        int temp = 0;
        for (int i = arr.length -1 ; i >= 0; i--) {
            for (int j = 0; j < i ; j++) {
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    //优化一下，不用每次交换  但是不稳定
    private static void bubbleSortOpt(int[] arr) {
        if(arr.length < 2 || arr == null){
            return;
        }
        int maxIndex = 0;
        for (int i = arr.length -1 ; i >= 0; i--) {
            for (int j = 0; j < i ; j++) {
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }

}
