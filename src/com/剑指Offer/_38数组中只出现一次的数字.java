package com.剑指Offer;

import java.util.Scanner;

/**
 * @DESC 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @CREATE BY @Author pbj on @Date 2020/5/19 15:51
 */
public class _38数组中只出现一次的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce pro = new FindNumsAppearOnce();
        pro.fun(nums, num1, num2);

        System.out.println(num1[0] + " --- " + num2[0]);
    }
}
class FindNumsAppearOnce {
    public void fun(int [] nums,int[] num1, int[] num2) {
        if(nums == null || nums.length == 0){
            return;
        }
        int xor = 0;
        int bit = 1;
        for(int num : nums){
            xor ^= num;
        }
        for(; bit <= xor; bit <<= 1){
            if((xor & bit) == bit){
                break;
            }
        }
        for(int num : nums){
            if((num & bit) == bit){
                num1[0] ^= num;
            }else{
                num2[0] ^= num;
            }
        }
    }
}