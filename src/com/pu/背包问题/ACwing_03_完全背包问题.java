package com.pu.背包问题;

/**
 * @DESC
 /*
有 N 种物品和一个容量是 V的背包，每种物品都有无限件可用。
第 i种物品的体积是 vi，价值是 wi
求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
输出最大价值。
输入格式
第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
接下来有 N行，每行两个整数 vi,wi，用空格隔开，分别表示第 i种物品的体积和价值。
输出格式
输出一个整数，表示最大价值。
数据范围
0<N,V≤1000
0<vi,wi≤1000
输入样例
4 5
1 2
2 4
3 4
4 5

输出样例：

10

 */

import java.util.Scanner;

/**
 * @CREATE BY @Author pbj on @Date 2020/5/7 14:38
 */
public class ACwing_03_完全背包问题 {
    static final int L = 1010;
    static int N, M;
    static int[] V = new int[L];
    static int[] W = new int[L];
    static int[] dp = new int[L]; //1维dp
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            V[i] = sc.nextInt();
            W[i] = sc.nextInt();
        }
        for(int i = 0; i <= N; i++){
            for(int j = V[i]; j <= M; j++){
                dp[j] = Math.max(dp[j], dp[j - V[i]] + W[i]);
            }
        }
        System.out.println(dp[M]);
    }
}
