package com.笔试.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2021/3/10 20:28
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] goods = new int[n];
        for (int i = 0; i < n; i++) {
            goods[i] = sc.nextInt();
        }
        int[] cars = new int[10];
        for (int i = 0; i < 10; i++) {
            cars[i] = sc.nextInt();
        }
        int cost1 = 0;
        int maxRes = 0;
        int carCost1 = 0;
        int sum = 0;
        for(int i = 0; i < 10; i++){
            carCost1 = cars[i];
            cost1 = 0;
            for(int k = 0; k < n; k += i + 1){
                sum = 0;
                for(int p = k; p < (k + i + 1 > n ? n : k + 1 + i); p++){
                    sum += goods[p];
                }
                cost1 += sum * sum;
            }
            maxRes = Math.max(maxRes, cost1 - carCost1);
        }
        System.out.println(maxRes < 0 ? 0 : maxRes);
    }
}
