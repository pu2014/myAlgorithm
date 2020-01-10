package com.pu.数字;

/**
 * description：求出1~13的整数中1出现的次数,并算出100~1300的整数中1
 * 出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13
 * 因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把
 * 问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * @author Pubojian
 * @date 2019/12/29 20:17
 */
public class 从1到n整数中1出现的次数 {
    public static void main(String[] args) {
        int n = 214159;
        System.out.println(numberOf1Between1AndNV1(n));
        System.out.println(numberOf1Between1AndNV2(n));
        System.out.println(numberOf1Between1AndNV3(n));

    }

    private static int numberOf1Between1AndNV3(int n) {
        /**
         * Description:对V2版本的优化。
         * @auther  newCoder
         */
        if(n < 1){
            return 0;
        }
        int res = 0;
        int a = 0;
        int b = 0;
        for (int i = 1; i <= n; i *= 10) {
            a = n / i;
            b = n % i;
            res += (a + 8) / 10 * i + (a % 10 == 1 ? (b + 1) : 0);
        }
        return res;
    }

    private static int numberOf1Between1AndNV2(int n) {
        /**
         * Description: 通过数的个位数，十位数等来求
         * @auther pubojian
         */
        if(n < 1){
            return 0;
        }
        int res = 0; //返回的总数
        int a = 0; //高位数
        int b = 0; //低位的数
        for(int i = 1; i <= n; i *= 10){
            a = n / i;
            b = n % i;
            if(a % 10 == 0){ //该位上为0 则前面该位置为1的数为0~(a/10-1)  * i；
                res += (a / 10) * i;
            }else if(a % 10 == 1){ //该位置为1，则前面为 0~(a/10-1)  * i 和 为1是后面的全部数 0~b
                res += (a / 10) * i + (b + 1);
            }else {// 大于2  则为 0~(a/10)  * i
                res += (a / 10 + 1) * i;
            }
        }
            return res;
    }

    public static  int numberOf1Between1AndNV1(int n) {
       /**
        * Description:1--n 的 分别计算
        *        计算规则：求余数判断
        *        O(n)
        * @auther pubojian
        */
        if(n <= 0){
            return 0;
        }
        int res = 0;
        while(n > 0){
            res = res + getTheNumOf1(n);
            n--;
        }
        return res;
    }
    public static  int getTheNumOf1(int n){
        int res = 0;
        while(n > 0){
            if(n % 10 == 1){
                res++;
            }
            n = n / 10;
        }
        return res;
    }
}
