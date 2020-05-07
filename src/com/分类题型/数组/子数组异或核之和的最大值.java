package com.分类题型.数组;

import java.util.HashMap;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/14 21:48
 */
public class 子数组异或核之和的最大值 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,5,4,5,4};
        System.out.println(getTheXORNums(nums));
    }

    private static int getTheXORNums(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int ans = 0;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[nums.length];
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
            if(map.containsKey(xor)){
                int pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : dp[pre] + 1;
            }
            if(i > 0){
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            map.put(xor, i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
