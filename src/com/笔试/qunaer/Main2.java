package com.笔试.qunaer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/23 19:48
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str1 = br.readLine().trim().replaceAll("\\s*","");
        String str2 = br.readLine().trim().replaceAll("\\s*","");
        System.out.println(n);
        System.out.println(str1);
        System.out.println(str2);
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = str1.charAt(i), c2 = str2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
