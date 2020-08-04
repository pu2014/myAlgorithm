package com.分类题型.动态规划.扔鸡蛋;

/**
 * @DESC 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * @CREATE BY @Author pbj on @Date 2020/8/4 9:04
 */
public class _96不同的二叉搜素树 {
    //思路: 有序数列 1 2  3  4
    // 以每一个点为根节点。 例如 i = 2； 前面 1 2   后面为 4
    //转化为 f(2) * f(4)
    // 所以 g(n) = (i-0-n) f(i-1)f(n-i)
    static class Solution {
        public int numTrees(int n) {
            // n == 1 1 为 根
            // n == 2 1 为根 2 为 根，
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for(int i = 2; i <= n; i++){
                for(int j = 1; j <= i; j++){
                    dp[i] = dp[j - 1]*dp[i-j];
                }
            }
            return dp[n];
        }
    }
}
