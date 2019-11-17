package com.pu.数组;

import java.util.Arrays;

public class 数组交换位置_空间度 {
    //达到最小空间度需求
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};  //要求输出{6,7,1,2,3,4,5}
        int temp = 0;
        for (int i = 0; i < 5 >> 1; i++) {
            temp = arr[i];
            arr[i] = arr[4 - i];
            arr[4 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
        temp = arr[6];
        arr[6] = arr[5];
        arr[5] = temp;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length >> 1 ; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(arr));

    }
}
