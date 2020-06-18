package com.笔试.IEEE;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/14 14:28
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            System.out.println(getTheTime(num));
        }
    }

    private static int getTheTime(int num) {
        int len = num * 4;
        int[] vis = new int[len];
        int count = 0;
        int i = 0;
        while(true){
            i = (i + (num + 1)) % len;
            vis[i]++;
            count++;
            if(vis[i] == 2){
                break;
            }
        }
        return count;
    }
}
