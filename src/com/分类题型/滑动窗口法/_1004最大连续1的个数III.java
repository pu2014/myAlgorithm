package com.分类题型.滑动窗口法;

import com.tools.MyInput;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/24 9:29
 */
public class _1004最大连续1的个数III {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(new Solution().longestOnes(nums, k));
    }
    static class Solution {
        public int longestOnes(int[] nums, int K) {
            int max = 0;
            int ll = 0;
            int rr = 0;
            int zero = 0;
            while(rr < nums.length){
                if(nums[rr] == 0){
                    zero++;
                }
                while(zero > K){
                    if(nums[ll++] == 0){
                        zero--;
                    }
                }
                max = Math.max(max, rr - ll + 1);
                rr++;
            }
            return max;
        }
    }
}
