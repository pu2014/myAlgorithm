package com.剑指Offer;

/**
 * Description:
 *      求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * Created By @Author my on @Date 2020/4/27 22:48
 */
public class _30整数中1出现的次数 {
    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN_Solution().method1(216));
        System.out.println(new NumberOf1Between1AndN_Solution().method2(216));
    }
}
class NumberOf1Between1AndN_Solution {
    public int method1(int n) {
        if(n <= 0){
            return 0;
        }
        int count = 0;
        for(int i = n; i > 0; i--){
            for(int j = i; j > 0; j = j / 10){
                if(j % 10 == 1) count++;
            }
        }
        return count;
    }
    public int method2(int n){
        if(n <= 0){
            return 0;
        }
        int count = 0;
        for(int i = 1; i <= n; i *= 10){
            int a = n / i;
            int b = n % i;
            //count += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
            if(a % 10 == 0){
                count += (a / 10) * i;
            }else if(a % 10 == 1){
                count += (a / 10) * i + (b + 1);
            }else{
                count += (a / 10) * i + i;
            }
        }
        return count;
    }
}