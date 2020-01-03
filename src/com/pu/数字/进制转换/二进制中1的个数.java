package com.pu.数字.进制转换;

/**
 * description：输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 *
 * @author Pubojian
 * @date 2020/1/2 22:36
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(7));
        System.out.println(NumberOf1(-7));
        System.out.println(NumberOf1(16));
        System.out.println(NumberOf1(-16));
        System.out.println(NumberOf1V2(7));
        System.out.println(NumberOf1V2(-7));
        System.out.println(NumberOf1V2(16));
        System.out.println(NumberOf1V2(-16));
    }

    private static int NumberOf1V2(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static int NumberOf1(int n) {
        /*
        正数：依次求2的余数可以求出
        负数：int 为 32 位
            分奇偶数 111型和000型
            偶数：需要计算最后连1的个数变化
            奇数：直接 32 - 正数的个数 + 1

        */
        if(n == 0){
            return 0;
        }else if(n > 0){
            return PositiveNumberOf1(n)[0];
        }else{
            int[] num = PositiveNumberOf1(-n);
            return 33 - num[0] - num[1];
        }
    }
    public static int[] PositiveNumberOf1(int n){
        int i = 0; //总体1的个数
        int m = 0; //111型结尾的连1数
        if((n & 1) == 1){//奇数，不考虑连0；
            while(n != 0){
                if(n % 2 == 1){
                    i++;
                }
                n = n >> 1;
            }
            return new int[] {i, 0};
        }else{//偶数
            int count = 0;
            boolean flag = false;
            while(n != 0){
                if(n % 2 == 0){
                    count++;
                }else{
                    i++;
                }
                if(i == 1 && flag == false){
                    m = count;
                    flag = true;
                }
                n = n >> 1;
            }
            return new int[] {i, m};
        }

    }
}
