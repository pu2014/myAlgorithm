package com.pu.递归;


import java.util.Arrays;

public class 递归_求小和 {
    public static void main(String[] args) {
        int[] arr = {4,1,3,5,0,6};
        //int[] arr = {4,1,3,5,0,6};
        int sum = getLittleSum(arr);
        System.out.println(sum);
        System.out.println(Arrays.toString(arr));

    }

    private static int getLittleSum(int[] arr) {
        if(arr == null || arr.length < 2){
            return 0;
        }
        return getSort(arr,0,arr.length-1);
    }
    private static int getSort(int[] arr,int left, int right){
        if(left == right)
            return 0;
        //int mid  = (left + right) >> 1; //向下取整
        int mid = left + ((right - left) >> 1);
        return getSort(arr,left,mid) + getSort(arr,mid + 1,right) + merge(arr,left,mid,right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p = left;  //左指针
        int q = mid + 1; //右指针
        int dst = 0;
        while (p <= mid && q <= right){
            dst += arr[p] < arr[q] ? (right - q + 1) * arr[p] : 0;
            temp[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
        }
        while(p <= mid){
            temp[i++] = arr[p++];
        }
        while (q <= right){
            temp[i++] = arr[q++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[left + j] = temp[j];
        }
        return dst;
    }
}
