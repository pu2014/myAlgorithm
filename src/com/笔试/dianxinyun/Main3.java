package com.笔试.dianxinyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/9 21:02
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(",");
        int[] nums = Arrays.stream(strs).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(nums));
        if(nums == null || nums.length == 0){
            System.out.println(0);
        }else if(nums.length == 1){
            System.out.println(nums[0]);
        }else {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            System.out.println(dp[nums.length - 1]);
        }
    }
}
