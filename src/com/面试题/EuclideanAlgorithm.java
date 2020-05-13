package com.面试题;

/**
 * @DESC 欧几里得辗转相除法，求最大公约数和最小公倍数
 *  两个正整数(a > b)  他们最大公约数等于a除以b的余数c和较小数的b之间的最大公约数
 *
 *  最小公倍数就是两个数的乘积除以最大公约数。
 * @CREATE BY @Author pbj on @Date 2020/5/13 10:42
 */
public class EuclideanAlgorithm {
    public static int maximumNumberOfConventions(int a, int b){
        int max, min, t;
        max = Math.max(a, b);
        min = Math.min(a, b);
        if(max % min == 0){
            return min;
        }

        t = max % min;
        while(t != 0){
            max = min;
            min = t;
            t = max % min;
        }
        return min;
    }

    public static int minCommonMultiple(int a, int b){
        return a * b / maximumNumberOfConventions(a, b);
    }

    public static void main(String[] args) {
        System.out.println(maximumNumberOfConventions(8, 6));
        System.out.println(minCommonMultiple(8, 6));
    }

}
