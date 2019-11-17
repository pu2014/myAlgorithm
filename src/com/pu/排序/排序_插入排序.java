package com.pu.排序;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度：最好情况下O(n)  最差情况 O(n^2)
 * 空间复杂度：o(1)
 * 稳定
 */

public class 排序_插入排序 {
    public static void main(String[] args) {
        int[] arr = {34,35,23,46,54,64,56,45,70,7,89,7};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        if(arr.length < 2 || arr == null)
            return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    private static void swap(int[] arr,int i, int j){
        //^异或符号
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
