package com.剑指Offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @DESC
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 *
 * 对应每个测试案例，输出两个数，小的先输出。
 * @CREATE BY @Author pbj on @Date 2020/5/19 16:53
 */
public class _40和为S的两个数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        FindNumbersWithSum proc = new FindNumbersWithSum();
        System.out.println(proc.fun(nums, M));
    }
}
class FindNumbersWithSum {
    public ArrayList<Integer> fun(int [] nums, int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0 || sum < nums[0]){
            return res;
        }
        int L = 0;
        int R = nums.length - 1;
        int s = 0;
        while(L < R){
            s = nums[L] + nums[R];
            if(s > sum){
                R--;
            }else if(s < sum){
                L++;
            }else{
                res.add(nums[L]);
                res.add(nums[R]);
                break;
            }
        }
        return res;
    }
}
