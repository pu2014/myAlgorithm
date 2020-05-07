package com.分类题型.数组;

import java.util.Arrays;

public class 两不重复数组找相同 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,4,6,7,8,9};
        int[] arr2 = {2,3,6,7,8,10};
        System.out.println(Arrays.toString(getTheSameNum(arr1,arr2)));
    }

    private static int[] getTheSameNum(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length > arr2.length ? arr2.length : arr1.length];
        int[] dst;
        int i = 0,j = 0,k = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] > arr2[j]){
                j++;
            }else if(arr1[i] < arr2[j]){
                i++;
            }else {
                arr[k++] = arr1[i++];
            }
        }
        dst = Arrays.copyOfRange(arr,0,k);
        return dst;
    }
}
