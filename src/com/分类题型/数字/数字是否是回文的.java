package com.分类题型.数字;

/**
 * @Description:判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * require： int x 不用其余空间
 * @Author: pubojian
 * @Date: Created in 19:21 2019/11/28
 **/
public class 数字是否是回文的 {
    public static void main(String[] args) {
        int x = 87655678;
        System.out.println(isPalindrome(x));
        System.out.println(isPalindromeV2(x));
    }

    public static boolean isPalindromeV2(int x){
        /**
         *@Description：如果采用反转数字会出现溢出情况，提出反转一半判断就不用考虑溢出问题了。
         *@Author: leetcode
         *@Date: 2019/11/28 19:27
         **/
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int res = 0;
        while(res < x){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return res == x;

    }

    public static  boolean isPalindrome(int x) {
        /**
         *@Description：自己写的采用类似双指针
         *@Author: pbj
         *@Date: 2019/11/28 19:26
         **/
        if(x < 0){
            return false;
        }
        int x1 = x;
        int num = 0;
        //判断几位数
        while(x1 != 0){
            num++;
            x1 = x1 / 10;
        }
        //一位数直接返回
        if(num == 1){
            return true;
        }else{
            //双指针法
            int i = 0;
            int mod = 0;
            int div = 0;
            num--;
            x1 = x;
            while(i < num){
                div = x1 /(int) Math.pow(10,num);
                mod = (x/(int)(Math.pow(10,i))) % 10;
                if(div == mod){
                    x1 = x1 % (int) Math.pow(10,num);
                    num--;
                    i++;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
