package com.分类题型.动态规划.凑零钱;

import com.tools.MyInput;

import java.util.Scanner;

/**
 * @DESC
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/6/23 9:55
 */
public class _518零钱兑换2 {
    public static void main(String[] args) {
        int target = new Scanner(System.in).nextInt();
        int[] ints = MyInput.inputArray();

        System.out.println(new Solution().change(target, ints));
    }

    /**
     * 这次是计算次数，为了避免重复计算，需要先遍历硬币
     *  注意组合数和排列数
     */
    static class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for(int coin : coins){
                for(int i = coin; i <= amount; i++){
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }
    }
}
