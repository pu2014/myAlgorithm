package com.笔试.yuanfudao;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/22 20:05
 */
public class YFDMain1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int i = 1;
        while(i <= n){
            System.out.print(nums[i - 1] + " ");
            i *= 2;
        }
        int k = (i >> 1);
        i = k + 1;
        while(i <= n){
            System.out.print(nums[i - 1] + " ");
            i++;
        }
        if(n != 2 * k - 1){
            i = i / 2;
            while(i <= k - 1){
                System.out.print(nums[i - 1] + " ");
                i++;
            }
        }
        i--;
        i /= 2;
        while(i > 1){
            System.out.print(nums[i - 1] + " ");
            i /= 2;
        }
        System.out.println();
    }
}
