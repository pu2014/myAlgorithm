package com.分类题型.排序;
/**
 * 归并排序
 *
 * 递归
 * 两步走 ：先归再并
 *
 * 时间复杂度：T(n) = T(n/2)左 + T(n/2)右 + O(n)合并 = 2T(n/2) + O(n)
 *           由公式：a = 2 b = 2 d = 1  第三种情况 得到 o(NlogN)
 * T(n) = aT(n/b) + O(n^d)  公式法
 *         logb(a) > d  O(N^logb(a))
 *         d > logb(a)  0(N^d)
 *         d = logb(a)  0(N^dlogN)
 * 空间复杂度：T(n)
 * 稳定性：可以做到稳定  左边的<=实现
 */

import java.util.Arrays;

public class 排序_归并排序 {
    public static void main(String[] args) {
        int[] arr = {12, 3, 54, 76, 59, 80, 38, 6, 50, 24, 20, 4, 82};
        mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr,int L,int R) {
        if (L == R)
            return;
        int mid = L + ((R - L) >> 1);
        mergeSort(arr,L,mid);
        mergeSort(arr,mid + 1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] ex = new int[R - L + 1];
        int i = 0; //ex数组的坐标
        int p = L;
        int q = mid + 1;
        while(p <= mid && q <= R){
            ex[i++] = arr[p] < arr[q] ? arr[p++]:arr[q++];
        }
        while(p <= mid){
            ex[i++] = arr[p++];
        }
        while (q <= R){
            ex[i++] = arr[q++];
        }
        for (int j = 0; j < ex.length; j++) {
            arr[L + j] = ex[j];
        }
    }
}
