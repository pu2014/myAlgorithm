package com.笔试.bytedance;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/7/25 10:32
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int res = 0;
        if(a <= b){
            for(int i = 1; i <= a/2; i++){
                res += a/i;
            }
            res += a - a/2;
        }else{
            if(b <= a/2){
                for(int i = 1; i <= b; i++){
                    res += a/i;
                }
            }else{
                for(int i = 1; i <= a/2; i++){
                    res += a/i;
                }
                res += b - a/2;
            }
        }
        System.out.println(res);

    }
}
