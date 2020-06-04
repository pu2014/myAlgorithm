package com.分类题型.动态规划.数组动态规划;

import com.tools.MyInput;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/4 16:41
 */
public class _152乘积最大子数组 {
    public static void main(String[] args) {
        int[] nums = MyInput.inputArray();
        MaxProduct proc = new MaxProduct();
        System.out.println(proc.maxProduct(nums));
    }
}
class MaxProduct {
    public int maxProduct(int[] nums) {
        // 转移方程 nums[i-1]/正负有关
        if(nums == null || nums.length == 0){
            return 0;
        }
        int preMax = nums[0];
        int preMin = nums[0];
        int max = nums[0];
        int tmp1,tmp2;
        for(int i = 1; i < nums.length; i++){
            tmp1 = nums[i]*preMax;
            tmp2 = nums[i]*preMin;
            preMax = Math.max(tmp1, Math.max(tmp2, nums[i]));
            preMin = Math.min(tmp1, Math.min(tmp2, nums[i]));
            max = Math.max(max, Math.max(preMax, preMin));

        }
        return max;
    }
}