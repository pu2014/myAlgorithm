package com.剑指Offer;

/**
 * description：动态递归实现
 *
 * @author Pubojian
 * @date 2020/2/29 15:02
 */
public class _07斐波拉契和跳台阶 {
    public static void main(String[] args) {
        DP d = new DP();
        System.out.println(d.Fibonacci(10));
        System.out.println(d.JumpFloor(10));
    }
}
class DP {
    public int Fibonacci(int n) {
        if(n < 2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int JumpFloor(int target) {
        if(target <= 0){
            return 0;
        }
        if(target <= 2){
            return target;
        }
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < target + 1; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}