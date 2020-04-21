package com.剑指Offer;

/**
 * Description:
 * {6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和
 * Created By @Author my on @Date 2020/4/21 21:56
 */
public class _29连续子数组的最大和 {
    public static void main(String[] args) {
        int[] nums = {6,-3,-2,7,-15,1,2,2};
        System.out.println(new FindGreatestSumOfSubArray().method(nums));
    }
}
class FindGreatestSumOfSubArray {
    public int method(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(sum < 0){
                sum = 0;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}

