package com.剑指Offer;

/**
 * description：快速幂运算
 * 2 ^ 5 = (2 ^ 2) ^ 2 * 2
 * 2 ^ 6 = (2 ^ 2) ^ 3
 * @author Pubojian
 * @date 2020/3/4 10:12
 */
public class _11数值的整数次方 {
    public static void main(String[] args) {
        MyPower mp = new MyPower();
        System.out.println(mp.Power(2.0, 4));
        System.out.println(mp.Power(2.0, 5));
        System.out.println(mp.Power(2.0, 9));
    }

}
class MyPower {
    public double Power(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        if(base == 0){
            return 0;
        }
        double res = 1.0;
        boolean flag = exponent < 0 ? false : true;
        exponent = exponent < 0 ? -exponent : exponent;
        while(exponent > 0){
            if(exponent % 2 == 1){
                res *= base;
            }
            exponent >>= 1;
            base *= base;
        }
        return flag ? res : 1 / res;
    }
}
