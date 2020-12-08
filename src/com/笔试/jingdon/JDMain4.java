package com.笔试.jingdon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/17 20:04
 */
public class JDMain4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        while(times-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] mat = new char[n][m];
            for(int i = 0; i < n; i++){
                String s = sc.nextLine();
                mat[i] = s.toCharArray();
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(mat[i][j] == 'S'){
                        mat[i][j] = '.';
                        infect(mat, i, j, mat.length, mat[0].length);
                        break;
                    }
                }
            }
            /*
2
2 2
.E
S.
2 2
#E
S#
             */

            boolean res = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(mat[i][j] == 'E'){
                        if(i > 0 && mat[i - 1][j] == '0') {
                            res = true;
                        }
                        if(i < mat.length - 1 && mat[i + 1][j] == 'O'){
                            res = true;
                        }
                        if(j > 0 && mat[i][j - 1] == 'O'){
                            res = true;
                        }
                        if(j < mat[0].length - 1 && mat[i][j + 1] == 'O'){
                            res = true;
                        }
                        break;
                    }
                }
            }
            System.out.println(res ? "YES" : "NO");
        }
    }
    public static void infect(char[][] m, int i, int j, int row, int col){
        if(i < 0 || i >= row || j < 0 || j >= col || m[i][j] != '.'){
            return;
        }
        m[i][j] = 'O';
        infect(m,i + 1, j , row, col);
        infect(m,i - 1, j , row, col);
        infect(m, i, j + 1 , row, col);
        infect(m, i, j - 1, row, col);
    }
}
