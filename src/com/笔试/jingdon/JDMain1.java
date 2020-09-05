package com.笔试.jingdon;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/27 19:59
 */
public class JDMain1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        if(index == 1){
            System.out.println(2);
        }else if(index == 2){
            System.out.println(3);
        }else if(index == 3){
            System.out.println(5);
        }else {
            int[] res = new int[index];
            res[0] = 2;
            res[1] = 3;
            res[2] = 5;
            int n2 = 0;
            int n3 = 0;
            int n5 = 0;
            for (int i = 3; i < index; i++) {
                res[i] = (Math.min(res[n2] * 10 + 2, Math.min(res[n3] * 10 + 3, res[n5] * 10 + 5)));
                if (res[i] == res[n2] * 10 + 2) {
                    n2++;
                }
                if (res[i] == res[n3] * 10 + 3) {
                    n3++;
                }
                if (res[i] == res[n5] * 10 + 5) {
                    n5++;
                }
            }
            System.out.println(res[index - 1]);
        }
    }
}
