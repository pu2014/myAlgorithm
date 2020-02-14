package com.pu.数组;

import java.util.HashMap;

/**
 * description：
 * 给定一个确定值，找出数组中满足子数组之和等于该值且长度最长的数组，并返回长度。
 *
 * 特点：
 * 1：设置sum，代表以i点为结尾的子数组的和。
 * 2：sum = aim - n； 如果n值在前面的sum和中出现过，表示这中间值为aim。
 * 321161（sum == 14）-7 （sums：0，3，5，6，7）
 *
 * @author Pubojian
 * @date 2020/2/14 18:33
 */
public class 子数组之和为aim的最大长度 {
    public static void main(String[] args) {
        int[] nums = {7,3,2,1,1,7,-6,-1,7,7,7};
        System.out.println(getLongestSumSubArrayLength(nums, 7));
    }

    private static int getLongestSumSubArrayLength(int[] nums, int aim) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int len = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - aim)){
                len = Math.max(i - map.get(sum - aim), len);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;

    }
}
