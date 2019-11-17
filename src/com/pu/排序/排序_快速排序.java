package com.pu.排序;

import java.util.Arrays;

/**
 * 核心 partition（荷兰旗问题）
 * 左右坐标的问题
 * 时间复杂度  NlogN   随机选取标定值（经典排序）
 * 最差情况 N^2
 * 空间复杂度    logN  最差O(N)
 * 稳定性      不稳定
 *
 */

public class 排序_快速排序 {
    public static void main(String[] args) {
        int[] arr = {12,3,54,76,59,8,8,6,50,24,20,4,8};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        quickSorting(arr,0,arr.length - 1);

    }

    private static void quickSorting(int[] arr, int left, int right) {
        if(left < right) {
            int[] index = partition(arr, left, right);
            quickSorting(arr, left, index[0] - 1);
            quickSorting(arr, index[1] + 1, right);
        }
    }

    private static int[] partition(int[] arr, int left, int right) {
        //随机选取，经典排序
        int pivot = arr[(int)Math.random()*(right - left + 1) + left];
        int i = left;
        while(i <= right){
            if(arr[i] < pivot){
                swap(arr,i++,left++);
            }else if(arr[i] > pivot){
                swap(arr,i,right--);
            }else {
                i++;
            }
        }
        return new int[]{left,right};
    }

    private static void swap(int[] arr, int i, int j) {
        if(i == j)
            return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
