package com.pu.背包问题;

import java.util.*;

/**
 * @DESC
 * 有 N 件物品和一个容量是 V的背包。每件物品只能使用一次。
 * 第 i件物品的体积是 vi，价值是 wi
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 * 接下来有 N行，每行两个整数 vi,wi，用空格隔开，分别表示第 i件物品的体积和价值。
 * 输出格式
 * 输出一个整数，表示最大价值。
 * 数据范围
 * 0<N,V≤1000
 * 0<vi,wi≤1000
 * 输入样例
 */
/*
4 5
1 2
2 4
3 4
4 5
*/
/**
 * 输出样例：
 *
 * 8
 * @CREATE BY @Author pbj on @Date 2020/5/7 12:11
 */
public class ACwing_02_01背包问题 {
    /**
     * f[i][j] 表示只看当前i个物品，总体积是j的情况下，总价值最大为多少
     * result = max{f[n][0-v]}
     *
     * f[i][j]:
     *      * 不选第i个物品：f[i][j] = f[i - 1][j];
     *      * 选第i个物品：f[i][j] = f[i - 1][j - v[i]] + w[i]
     * f[i][j] = max{1,2}
     * f[0][0] = 0;
     * @param args
     */
    static final int L = 1010;
    static int N, M;
    static int[] V = new int[L];
    static int[] W = new int[L];
    static int[] one = new int[L]; //1维dp
    static int[][] dp = new int[L][L];//2维dp
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i = 1; i <= N; i++){
            V[i] = sc.nextInt();
            W[i] = sc.nextInt();
        }
        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= M; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= V[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - V[i]] + W[i]);
            }
        }
        for(int i = 1; i <= N; i++){
            /**
             * 如果从小到大遍历
             * 第一个物品 j = 0 (4,5)  dp[0] = 0; ... dp[2] = 0; dp[4] = max(0, dp[4-4] + 5) = 5, dp[5] = 5
             * 第二个物品 j = 1 (1,2)  dp[0] = 0; dp[1] = (0, 2) = 2, dp[2] = (0,dp[1] + 2) = 4 ...会重复计算
             *
             * 如果从大到小遍历
             * 第一个物品 j = 0 (4,5) dp[5] = (0, 0+5) = 5; dp[4] = 5
             * 第二个物品 j = 1 (1,2) dp[5] = (5, dp[4] + 2) = 7 dp[4] = (dp[3] + 2, 5) = 5; dp[3] = 2 dp[2] = 2 d[1] = 2
             * 第三个物品 j = 2 (2,4) dp[5] = (5, dp[3] + 4) = 7 dp[4] = (2 + 4, 5) = 6 ...
             * 如果M --> 0  f[n] = max  f[2] = max(0, dp[0]
             */
            for(int j = M; j >= V[i]; j--){
                one[j] = Math.max(one[j], one[j - V[i]] + W[i]);
            }
        }
        System.out.println(dp[N][M]);
        System.out.println(one[M]);
    }
}
