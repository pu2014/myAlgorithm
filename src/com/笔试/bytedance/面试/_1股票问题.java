package com.笔试.bytedance.面试;

import java.util.*;
/**
 * @DESC   1. 一次买卖
 *         2. 两次买卖
 *         3. k次买卖
 *         4  无限次
 *         5  冷冻期
 *         6  手续费
 * @CREATE BY @Author pbj on @Date 2020/7/28 8:47
 */
public class _1股票问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prices[] = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
        }
        //一次买卖
        System.out.println(max_pro_k1(prices));
    }

    /**
     * 一次买入最大值
     *  思路： 每天交易能获得的最大值
     *        每天卖能最小的成本值
     *        差值的最大
     * @param prices
     * @return
     */
    public static int max_pro_k1(int[] prices){
        int len = prices.length;
        int[][] dp = new int[len][2];
        //每天卖出的最大值
        dp[0][0] = 0;
        //每天买入的花费最小的值
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * 交易无穷多次
     *  思路： 每天交易获取的最大值
     *        每次成本的最小值+前面赚的钱
     * @param prices
     * @return
     */
    public static int max_pro_k8(int[] prices){
        int len = prices.length;
        int[][] dp = new int[len][2];
        //每天卖出的最大值
        dp[0][0] = 0;
        //每天买入的花费最小的值
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * k 次买卖
     * // 每天每次的最大收益
     *      前一天前一次的最大收益 - 当前成本 和 不卖的最大值
     *      插值
     * @param prices
     * @return
     */
    public static int max_pro_kk(int[] prices, int k){
        int len = 0;
        int[][][] dp = new int[len][k + 1][2];
        dp[0][k][0] = 0;
        dp[0][k][1] = -prices[0];
        for(int i = 1; i < len; i++){
            for(int j = k; k >= 1; k--){
                dp[i][j][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }

    /**
     * 一天的冷却期  卖了买之后需要等一天交易
     * @param prices
     * @return
     */
    public static int max_pro_ice(int[] prices){
        int len = prices.length;
        int[][] dp = new int[len][2];
        //每天卖出的最大值
        dp[0][0] = 0;
        //每天买入的花费最小的值
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    /**
     * 每次出售需要服务费，计算在成本之中即可
     * @param prices
     * @return
     */
    public static int max_pro_nofree(int[] prices, int free){
        int len = prices.length;
        int[][] dp = new int[len][2];
        //每天卖出的最大值
        dp[0][0] = 0;
        //每天买入的花费最小的值
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - free);
        }
        return dp[len - 1][0];
    }


}
