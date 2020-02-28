package com.LeetCode;

import java.util.Arrays;

/**
 * description：二分查找方法解决问题
 * 35. 搜索插入位置
 *      给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *      你可以假设数组中无重复元素。
 *      示例 1:
 *      输入: [1,3,5,6], 5
 *      输出: 2
 * 278. 第一个错误的版本
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *      给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *      你的算法时间复杂度必须是 O(log n) 级别。
 *      如果数组中不存在目标值，返回 [-1, -1]。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *

 *
 * @author Pubojian
 * @date 2020/2/28 9:51
 */
public class _07二分查找 {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,6,8,10};
        SearchInsert si = new SearchInsert();
        //输出2
        System.out.println(si.SearchInsert(nums1, 4));
        System.out.println(si.SearchInsertTwo(nums1, 4));

        int[] nums2 = {0,0,1,1,3,3,3,3,4,4,5,5,5};
        int[] sr = new find_first_and_last_position_of_element_in_sorted_array().searchRange(nums2, 3);
        System.out.println(Arrays.toString(sr));


    }

}
//todo 35. 搜索插入位置
class SearchInsert {
    public int SearchInsert(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < arr[0]) {
            return 0;
        }
        if (arr[arr.length - 1] < target) {
            return arr.length;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        /**
         * while(L <= R)
         * R = mid - 1;
         *
         * L = mid + 1;
         */
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }

    public int SearchInsertTwo(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < arr[0]) {
            return 0;
        }
        if (arr[arr.length - 1] < target) {
            return arr.length;
        }
        int L = 0;
        int R = arr.length;
        int mid = 0;
        /**
         * while(L <= R)
         * R = mid - 1;
         *
         * L = mid + 1;
         */
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }
}
//todo find_first_and_last_position_of_element_in_sorted_array
class find_first_and_last_position_of_element_in_sorted_array {
        public int[] searchRange ( int[] nums, int target){
            if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
                return new int[]{-1, -1};
            }
            int L = 0;
            int R = nums.length - 1;
            if (L == R && nums[L] == target) {
                return new int[]{0, 0};
            }
            int mid = 0;
            while (L <= R) {
                mid = L + ((R - L) >> 1);
                if (nums[mid] > target) {
                    R = mid - 1;
                } else if (nums[mid] < target) {
                    L = mid + 1;
                } else {
                    int LL = L;
                    int LR = mid;
                    int Lmid = 0;
                    int RL = mid;
                    int RR = R;
                    int Rmid = 0;
                    while (LL < LR) {
                        Lmid = LL + ((LR - LL) >> 1);
                        if (nums[Lmid] == target) {
                            LR = Lmid;
                        } else {
                            LL = Lmid + 1;
                        }
                    }
                    while (RL < RR) {
                        Rmid = RL + ((RR - RL + 1) >> 1);
                        if (nums[Rmid] == target) {
                            RL = Rmid;
                        } else {
                            RR = Rmid - 1;
                        }
                    }
                    return new int[]{LL, RL};
                }
            }
            return new int[]{-1, -1};
        }
    }