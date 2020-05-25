package com.面试题;

import java.util.Scanner;

/**
 * @DESC  判断一个数是否是2的幂次方
 * @CREATE BY @Author pbj on @Date 2020/5/14 10:20
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNext()) {
            int N = sc.nextInt();
            System.out.println((N & -N) == N);
        }
    }

}
