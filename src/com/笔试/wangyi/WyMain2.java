package com.笔试.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @DESC
 * 2 2
 * 1 2
 * 1 1
 * @CREATE BY @Author pbj on @Date 2020/8/12 20:50
 */
/*
3
1 0 0
0 10 10
0 10 10
 */
public class WyMain2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        for(int k = 0; k < n; k++){
            int r = mat.length;
            int[] rows = new int[r];
            int[] cols = new int[r];
            for(int i = 0; i < r; i++){
                for(int j = 0; j < r; j++){
                    rows[i] += mat[i][j];
                    cols[i] += mat[j][i];
                }
            }
            int[][] dp = new int[r][r];
            for(int i = 0; i < r; i++){
                for(int j = 0; j < r; j++){
                   dp[i][j] = rows[j] + cols[i] - mat[i][j];
                }
            }
            int max = 0;
            int L = 0;
            int R = 0;
            for(int i = 0; i < r; i++){
                for(int j = 0; j < r; j++){
                    if(max <= dp[i][j]){
                        if(max == dp[i][j] && L >= i && R >= j){
                            L = i;
                            R = j;
                        }else if(max < dp[i][j]){
                            max = dp[i][j];
                            L = i;
                            R = j;
                        }
                    }
                }
            }
            System.out.println((1 + L) + " " + (1 + R));
            if(r == 1){
                break;
            }
            int[][] temp = new int[r-1][r-1];
            int p = 0;
            int q = 0;
            for(int i = 0; i < r; i++){
                q = 0;
                if(i == L){
                    continue;
                }
                for(int j = 0; j < r; j++){
                    if(j == R){
                        continue;
                    }
                    temp[p][q++] = mat[i][j];
                }
                p++;
            }
            mat = temp;
        }

    }
}
