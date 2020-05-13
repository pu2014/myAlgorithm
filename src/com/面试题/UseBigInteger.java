package com.面试题;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @DESC 输入一个整数 n 1<n<10^9
 * 输出一个整数
 * 找出其所有非空子集中所有元素个数之和，然后对 10^9+7 取模，输出结果
 * 例如输入 2，有 {1}，{2}，{1，2} 3 个非空子集，所有元素个数之和为 4
 * 输出结果为 4
 *
 * * 公式 n * 2^(n-1)
 * @CREATE BY @Author pbj on @Date 2020/5/13 10:51
 */
public class UseBigInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        BigInteger res = count(new BigInteger(N));
        BigInteger mod = BigInteger.valueOf(10).pow(7).add(BigInteger.valueOf(7));
        System.out.println(res.mod(mod));
    }

    private static BigInteger count(BigInteger n) {
        return n.multiply(BigInteger.valueOf(2).pow(n.intValue() - 1));
    }
}
