package com.pu.动态规划;

/**
 * @Description: 有n级台阶，一个人每次上一级或者两级，
 * 有多少种走完n阶台阶的方法。
 * @Author:pubojian
 * @Date: Created in 14:01 2019/12/3
 **/
public class N级台阶问题 {
    public static void main(String[] args){
        System.out.println("暴力搜索：" + s1(10));
        System.out.println("记忆搜索：" + s2(10));
        System.out.println("动态递归搜索：" + s3(10));
    }

    private static int s3(int n) {
        /**
         *@Description：动态规划，自下而上解决
         *@Author:
         *@Date: 2019/12/3 14:12
         **/
        if(n < 1){
            return 0;
        }
        if(n == 1 || n == 2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n + 1; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int s2(int n) {
        /**
         *@Description：记忆化搜索  自上而下
         *@Author:
         *@Date: 2019/12/3 14:13
         **/
        if(n < 0){
            return 0;
        }
        int[] map = new int[n + 1];
        for(int i = 0; i <= n ;i++){
            map[i] = -1;
        }
        process(map, n);
        return map[n];
    }

    private static int process(int[] map, int n) {
        if(n  <= 2){
            return n;
        }
        if(map[n] == -1){
            map[n] = process(map,n - 1) + process(map,n - 2);
        }
        return map[n];
    }

    private static int s1(int n) {
        /**
         *@Description：暴力搜索  f(i) =  f(i - 1) + f(i -2)
         *@Author: pubojian
         *@Date: 2019/12/3 14:04
         **/
        if(n < 1){
            return 0;
        }
        if(n == 1 || n == 2){
            return n;
        }
        return s1(n - 1) + s1(n - 2);
    }

}

