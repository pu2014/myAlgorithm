package com.pu.递归;

/**
 * 母牛每年生一只母牛，
 * 新出生的母牛成长三年后也能每年生一只母牛，
 * 问题一 ：假设不会死，求n年后母牛的数量。
 * 问题二 ：假设牛的寿命为十年，求n年后母牛的数量。
 *
 * F(n) = F(n - 1) + F(n - 3)
 */
public class 递归_母牛问题 {
    public static void main(String[] args){
        int n = 12;
        int res = getNumNoDie(n);
        int res1 = getNumDie(n);
        System.out.println(res);
        System.out.println(res1);
    }

    private static int getNumDie(int n) {
        if(n < 1)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(n == 3)
            return 3;
        return getNumDie(n - 1)  // 去年的总数
                + getNumDie(n - 3)  //新生的崽
                - getNumDie(n - 10); // 要死去的牛
    }

    private static int getNumNoDie(int n) {
        if(n < 1)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(n == 3)
            return 3;
        return getNumNoDie(n - 1) //去年的牛总数
                 + getNumNoDie(n - 3); //能生的牛新生的个数。
    }
}
