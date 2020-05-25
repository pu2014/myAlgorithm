package com.分类题型.动态规划;

import com.tools.MyArrays;
import com.tools.Print;

import java.util.Arrays;

/**
 * Description:
 * leetcode 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * Created By @Author my on @Date 2020/3/23 11:34
 */
public class 凑零钱问题 {
    public static void main(String[] args) {
        int[] coins = MyArrays.createArray(10);
        Print.printArray(coins);
        System.out.println(new CoinChange().method(coins, 30));
    }
}
class CoinChange {
    public int method(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int coin : coins){
                if(i - coin < 0) continue;
                dp[i] = Math.min(dp[i],  1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}