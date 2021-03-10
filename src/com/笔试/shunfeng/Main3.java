package com.笔试.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2021/3/10 19:56
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        for(int i = 0; i < q; i++){
            int left = sc.nextInt();
            int right = sc.nextInt();
            if(right - left < 2){
                System.out.println("NoScore");
                continue;
            }
            int sum = 0;
            int max = -1;
            int min = Integer.MAX_VALUE;
            for(int k = left - 1; k < right; k++){
                max = Math.max(max, nums[k]);
                min = Math.min(min, nums[k]);
                sum += nums[k];
            }
            System.out.println((sum - max - min)/(right - left - 1));

        }
    }
}
