package com.分类题型.动态规划.双串动态规划;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/23 14:34
 */
public class _72编辑距离 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.nextLine();
        String text2 = sc.nextLine();
    }
    static class Solution {
        public int minDistance(String word1, String word2) {
            if(word1 == null || word1.length() == 0){
                return word2.length();
            }
            if(word2 == null || word2.length() == 0){
                return word1.length();
            }
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for(int i = 0; i <= word1.length(); i++){
                dp[i][0] = i;
            }
            for(int i = 0; i <= word2.length(); i++){
                dp[0][i] = i;
            }
            for(int i = 1; i <= word1.length(); i++){
                for(int j = 1; j <= word2.length(); j++){
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = Math.min(dp[i - 1][j] + 1, //删除
                                Math.min(dp[i][j - 1] + 1, //增加
                                        dp[i - 1][j - 1] + 1));//替换
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
}
