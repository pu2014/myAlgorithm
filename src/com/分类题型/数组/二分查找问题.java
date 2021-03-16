package com.分类题型.数组;

import static java.util.Arrays.binarySearch;

/**
 * description：二分查找模板问题
 * Arrays.binarySearch源码
 * private static int binarySearch0(int[] a, int fromIndex, int toIndex,
 *                                      int key) {
 *         int low = fromIndex;
 *         int high = toIndex - 1;
 *
 *         while (low <= high) {
 *             int mid = (low + high) >>> 1;
 *             int midVal = a[mid];
 *
 *             if (midVal < key)
 *                 low = mid + 1;
 *             else if (midVal > key)
 *                 high = mid - 1;
 *             else
 *                 return mid; // key found
 *         }
 *         return -(low + 1);  // key not found.
 *     }
 *
 * @author Pubojian
 * @date 2020/3/14 11:57
 */
public class 二分查找问题 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};

        System.out.println(binarySearch(nums, 8));
        System.out.println(binarySearch1(nums, 8));
        System.out.println(binarySearch2(nums, 8));
        System.out.println(binarySearch3(nums, 8, true));
        System.out.println(binarySearch3(nums, 8, false));
    }

    private static int binarySearch2(int[] nums, int target) {
        //L <= R
        int L = 0;
        int R = nums.length - 1;
        while(L <= R){
            int mid = L + ((R - L) >>> 1);
            if(nums[mid] < target){
                L = mid + 1;
            }else if(nums[mid] > target){
                R = mid - 1;
            }else{
                return mid;
            }
        }
        return L;
    }

    private static int binarySearch1(int[] nums, int target) {
        //L <= R
        int L = 0;
        int R = nums.length - 1;
        while(L <= R){
            int mid = L + ((R - L) >>> 1);
            if(nums[mid] < target){
                L = mid + 1;
            }else if(nums[mid] > target){
                R = mid;
            }else{
                return mid;
            }
        }
        return L;
    }

    private static int binarySearch3(int[] nums, int target, boolean lower) {
        //L <= R
        int L = 0;
        int R = nums.length;
        while(L < R){
            int mid = L + ((R - L) >>> 1);
            if(nums[mid] > target || ((lower) && nums[mid] >= target)){
                R = mid;
            }else{
                L = mid + 1;
            }
        }
        return L;
    }
}
