package com.pu.数字.进制转换;

/**
 * description：由5和 2 决定  2 的次数远大于5 求出5的次数就可以得到0的个数
 *
 * @author Pubojian
 * @date 2020/3/8 17:33
 */
public class 求N阶乘末尾0的个数 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(10));
        System.out.println(trailingZeroes(15));
        System.out.println(trailingZeroes(20));
    }

    public static int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
