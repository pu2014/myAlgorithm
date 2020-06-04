package com.分类题型.动态规划.数组动态规划;

import com.tools.MyInput;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/4 16:45
 */
public class _53最大子序和 {
    public static void main(String[] args) {
        int[] nums = MyInput.inputArray();
        MaxSubArray proc = new MaxSubArray();
        System.out.println(proc.maxSubArray(nums));
    }
}
class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            sum += num;
            max = Math.max(max, sum);
            if(sum < 0){
                sum = 0;
            }

        }
        return max;
    }
}
