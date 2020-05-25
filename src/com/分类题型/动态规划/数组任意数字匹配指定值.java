package com.分类题型.动态规划;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给你一个数组arr和一个整数aim，如果可以选择arr的数字，能不能得到aim，
 * 返回true或者false
 */
public class 数组任意数字匹配指定值 {
    public static void main(String[] args) {
        int[] arr = { 1, 8, 3, 2, 5, 9, 7};
        int aim1 = 10;
        int aim2 = 100;
        System.out.println(isHas1(arr,aim1));
        System.out.println(isHas1(arr,aim2));
        System.out.println(isHas2(arr,aim1));
        System.out.println(isHas2(arr,aim2));
        System.out.println(isHasDP(arr,aim1));
        System.out.println(isHasDP(arr,aim2));
    }

    private static boolean isHasDP(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for(int i = 0; i < dp.length; i++){ //目标金额这一列
            dp[i][aim] = true;
        }
        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = aim - 1; j >= 0; j--){
                dp[i][j] = dp[i + 1][j];
                if(j + arr[i] <= aim){
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    private static boolean isHas2(int[] arr, int aim) {
        return isSum(arr, 0, 0, aim);
    }

    private static boolean isHas1(int[] arr, int i) {
        final HashSet<Integer> set = new HashSet<>();
        process(arr, set, 0, 0);
        System.out.println(Arrays.toString(set.toArray()));
        if(set.contains(i)){
            return true;
        }else{
            return false;
        }
    }

    private static void process(int[] arr, HashSet<Integer> set, int i, int res) {
        if( i >= arr.length){
            return;
        }
        if(!set.contains(res)){
            set.add(res);
        }
        if(!set.contains(res + arr[i])){
            set.add(res + arr[i]);
        }
        process(arr, set, i + 1, res + arr[i]);
        process(arr, set, i + 1, res);

    }

    public static boolean isSum(int[] arr, int i, int sum, int aim){
        if(i == arr.length){
            return sum == aim;
        }
        return isSum(arr, i + 1, sum, aim) || isSum(arr, i + 1, sum + arr[i], aim);
    }
}
