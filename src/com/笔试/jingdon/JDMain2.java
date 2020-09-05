package com.笔试.jingdon;


import java.util.*;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/27 20:10
 */
public class JDMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> mat = new ArrayList<>();
        List<Integer> list;
        for(int i = 0; i < n; i++){
             list = new ArrayList<>();
             for(int j = 0; j < 2 * i + 1; j++){
                 list.add(sc.nextInt());
             }
             mat.add(list);
        }
        int len = (n - 1)*2 + 1;
        int[][] f = new int[n][len];
        f[0][0] = mat.get(0).get(0);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 2 * i + 1; j++){
                if(j == 0){
                    f[i][j] = f[i - 1][j] + mat.get(i).get(j);
                }else if(j == 1){
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - 1]) + mat.get(i).get(j);
                }else if(j == 2 * i){
                    f[i][j] = f[i - 1][j - 2] + mat.get(i).get(j);
                }else if(j == 2 * i - 1){
                    f[i][j] = Math.max(f[i - 1][j - 2], f[i - 1][j - 1]) + mat.get(i).get(j);
                }else{
                    f[i][j] = Math.max(f[i - 1][j], Math.max(f[i - 1][j - 1], f[i - 1][j - 2])) + mat.get(i).get(j);
                }
            }
        }
        int max = f[n - 1][0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, f[n - 1][i]);
        }
        System.out.println(max);
    }
}