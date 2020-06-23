package com.分类题型.动态规划.单串线性;

import com.tools.MyInput;

import java.util.Arrays;

/**
 * Description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4 
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created By @Author my on @Date 2020/6/3 10:08
 */
public class _300最长上升子序列 {
    public static void main(String[] args) {
        int[] nums = MyInput.inputArray();
        LengthOfLIS proc = new LengthOfLIS();
        System.out.println(proc.fun(nums));
        System.out.println(proc.fun2(nums));

    }
}

/**
 * 转移状态： if(nums[i] > nums[j]){ max{dp[i] + 1}} (j < i)
 *          else dp[i] = 1
 * 初始状态： dp[0..len] = 1;
 *
 * O(n^2)
 */
class LengthOfLIS {
    public int fun(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 优化: 减少复杂度到 NLogN
     * 思路： 主要是
     * @param nums
     * @return
     */
    public int fun2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int end = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > dp[end]){
                dp[++end] = nums[i];
            }else{
                int L = 0;
                int R = end;
                while(L < R){
                    int mid = L + (R - L)/2;
                    if(dp[mid] < nums[i]){
                        L = mid + 1;
                    }else{
                        R = mid;
                    }
                }
                dp[L] = nums[i];
            }
        }
        return end + 1;
    }

}
