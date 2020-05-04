package com.pu.排序;

import com.tools.MyArrays;
import com.tools.Print;

/**
 * 面试常考快排，归并思想及实现，堆排序运用也很广泛，所以在这里做一个汇总
 * Created by pu 2020.4.28
 */
public class Sort {
    /**
     * 冒泡排序：也称为石沉法，将大的数据放在最后、
     * 性能稳定
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序，每次将最小的放到最前面来
     * 性能稳定
     * @param nums
     */
    public static void selectSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    swap(nums, i, j);
                }
            }
        }
    }

    /**
     * 插入排序，主要是视为前面的数已经有顺序，然后将一个数字插入到该有序子数组中
     * @param nums
     */
    public static void insertSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[j + 1] < nums[j]){
                    swap(nums, j, j + 1);
                }
            }
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("bubbleSort");
        int[] nums1 = MyArrays.createArray(10);
        Print.printArray(nums1);
        bubbleSort(nums1);
        Print.printArray( nums1);

        System.out.println("selectSort");
        int[] nums2 = MyArrays.createArray(10);
        Print.printArray(nums2);
        selectSort(nums2);
        Print.printArray( nums2);

        System.out.println("insertSort");
        int[] nums3 = MyArrays.createArray(10);
        Print.printArray(nums3);
        insertSort(nums3);
        Print.printArray( nums3);
    }
}
