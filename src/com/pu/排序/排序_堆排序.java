package com.pu.排序;

import java.util.Arrays;
/*
    Arrays.sort（）  （注重稳定性)

                       arr.length < 60  插入排序（复杂度高，但是常数项低，当n较小时就很好）
                       arr.length > 60  归并排序或 排序的对象是自己定义的类（重写了比较器）
                                        者快速排序 排序的对象时基本类型（基础类型不关注稳定性，只要求快）
                                        分治拆分为60以内再用插入排序
    时间复杂度：
        建立大根堆 log1+log2+...logN --> O(n)
        交换调整    O(NlogN)  额外空间也为O(1)
        所以 O(NlogN)
        不稳定

        大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
        小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
        堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
        将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
        这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
 */

public class 排序_堆排序 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr2 = new int[10];
        for(int i = 0;i < 10;i++){
            arr[i] = (int)(Math.random() * 100);  // 0.0-0.99 包括0
        }
        for(int i = 0;i < 10;i++){
            arr2[i] = (int)(Math.random() * 100);  // 0.0-0.99 包括0
        }
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        heapSort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    private static void heapSort2(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        int heapSize = arr.length;
        while (heapSize > 0){
            for (int i = 0;i < heapSize;i++){
                heapInsert(arr,i);
            }
            swap(arr,0,--heapSize);
        }
    }


    private static void heapSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }

    }

    private static void heapify(int[] arr, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = left + 1;
        while(left < heapSize){
            int largest = right < heapSize && arr[right] > arr[left] ? right : left;
            largest = arr[largest] > arr[i] ? largest : i;
            if(largest == i){
                break;
            }
            swap(arr,largest,i);
            i = largest;
            left = i * 2 + 1;
            right = left + 1;
        }
    }

    /**
     * 如果
     * @param arr
     * @param i
     */
    private static void heapInsert(int[] arr, int i) {
        while (i > 0 && arr[i] > arr[(i - 1) >> 1]) {
            swap(arr, i, (i - 1) >> 1);
            i = (i - 1) >> 1;
        }
    }
    private static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
