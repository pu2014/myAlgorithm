package com.LeetCode;

import com.tools.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description：
 * 1：两数之和
 * 2：三数之和
 * 3：较小的三数之和
 * 4：最接近的三数之和
 * 4：四数之和  类推。。
 *
 * 排序 + 双指针
 * @author Pubojian
 * @date 2020/2/21 12:45
 */
public class _01数组的几数之和问题 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,2,3,4,-1,-1,-2,-2,0,0,8,6,5};
        int target = 7;

        int[] nums1 = nums.clone();
        List<List<Integer>> listTwoSum = twoSum(nums1, target);
        Print.listListPrint(listTwoSum);

        int[] nums2 = nums.clone();
        List<List<Integer>> listThreeSum = threeSum(nums2, target);
        Print.listListPrint(listThreeSum);

        int[] nums3 = nums.clone();
        System.out.println(threeSumClosest(nums3,80));

        int[] nums4 = nums.clone();
        List<List<Integer>> listThreeSumSmaller = threeSumSmaller(nums4, target);
        Print.listListPrint(listThreeSumSmaller);
    }

    private static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int L = 0;
        int R = len - 1;
        while(L < R){
            int sum = nums[L] + nums[R];
            if(sum == target){
                List<Integer> list = new ArrayList<>();
                list.add(nums[L]);
                list.add(nums[R]);
                res.add(list);

                while(L + 1 < R && nums[L] == nums[L + 1]){
                    L++;
                }
                while(R -1 > L && nums[R] == nums[R - 1]){
                    R--;
                }
                L++;
                R--;
            }else if(sum < target){
                L++;
            }else{
                R--;
            }
        }
        return res;
    }


    private static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 2; i++) {
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    res.add(list);

                    while (L + 1 < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (R - 1 > L && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < target) {
                    L++;
                } else {
                    R--;
                }
            }
            while(i + 1 < len - 2 && nums[i + 1] == nums[i]){
                i++;
            }
        }
        return res;
    }
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i] - target;
                if (Math.abs(sum) < Math.abs(min)) {
                    min = sum;
                }
                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    return sum + target;
                }
            }
        }
        return min + target;
    }

    private static List<List<Integer>> threeSumSmaller(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len - 2; i++) {
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum < target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    res.add(list);
                    while (L + 1 < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    L++;
                } else {
                    while (R - 1 > L && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    R--;
                }
            }
            while(i + 1 < len - 2 && nums[i + 1] == nums[i]){
                i++;
            }
        }
        return res;
    }
}
