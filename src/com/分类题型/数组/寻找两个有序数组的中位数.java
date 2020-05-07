package com.分类题型.数组;

/**
 * @Description:给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * @Author: pubojian
 * @Date: Created in 22:06 2019/11/19
 **/
public class 寻找两个有序数组的中位数 {
    public static void main(String[] args){
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArraysV2(nums1, nums2));

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int k1 = 0, k2 = 0, k = 0;
        int[] arr = new int[len];
        while(k1 < len1 && k2 < len2){
            if(nums1[k1] <= nums2[k2]){
                arr[k++] = nums1[k1++];
            }else{
                arr[k++] = nums2[k2++];
            }
        }
        if(k1 != len1){
            for(int i = k1; i < len1; i++){
                arr[k++] = nums1[i];
            }
        }
        if(k2 != len2){
            for(int i = k2; i < len2; i++){
                arr[k++] = nums2[i];
            }
        }
        int mid = len >> 1;
        if((len & 1) == 0){
            return (arr[mid] + arr[mid - 1]) / 2.0;
        }else{
            return (double)arr[mid];
        }

    }

    public static double findMedianSortedArraysV2(int[] nums1, int[] nums2) {
        /**
         *@Description： 优化，不需要那么多数组长度，只需要包括中位数即可
         *@Author: pubojian
         *@Date: 2019/11/21 19:14
         **/
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int mid = len >> 1;
        int k1 = 0, k2 = 0, k = 0;
        int[] arr = new int[mid + 1];
        while(k1 < len1 && k2 < len2 && k <= mid){
            if(nums1[k1] <= nums2[k2]){
                arr[k++] = nums1[k1++];
            }else{
                arr[k++] = nums2[k2++];
            }
        }
        while(k1 < len1 && k <= mid){
            arr[k++] = nums1[k1++];
        }
        while(k2 < len2 && k <= mid){
            arr[k++] = nums2[k2++];
        }

        if((len & 1) == 0){
            return (arr[mid] + arr[mid - 1]) / 2.0;
        }else{
            return (double)arr[mid];
        }

    }
}
