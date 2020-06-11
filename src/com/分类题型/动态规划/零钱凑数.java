package com.分类题型.动态规划;

import java.util.Arrays;

/**
 * @DESC 想兑换100元钱，有1,2,5,10四种钱，问总共有多少兑换方法?
 * @CREATE BY @Author pbj on @Date 2020/6/11 16:15
 */
public class 零钱凑数 {
    static int N = 10;
    static int[] dimes = {1,3,5};
    public static void main(String[] args) {
        int res = coinExchangeRecursion(N,dimes.length);
        System.out.println(res);
        int resdw = coinExchangeRecursionDW();
        System.out.println(resdw);
    }

    private static int coinExchangeRecursion(int n, int index) {
        if(n == 0){
            return 1;
        }
        if(n < 0 || index == 0){
            return 0;
        }
        return coinExchangeRecursion(n, index - 1) + coinExchangeRecursion(n - dimes[index - 1], index);
    }

    private static int coinExchangeRecursionDW() {
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for(int i = 0; i < dimes.length; i++){
            for(int j = dimes[i]; j <= N; j++){
                dp[j] += dp[j - dimes[i]];
            }
        }
        return dp[N];
    }
}
