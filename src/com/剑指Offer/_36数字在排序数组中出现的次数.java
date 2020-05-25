package com.剑指Offer;

import com.tools.Print;

import java.util.Scanner;

/**
 * @DESC 统计一个数字在排序数组中出现的次数。
 * @CREATE BY @Author pbj on @Date 2020/5/19 12:29
 */
public class _36数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        Print.out(new GetNumberOfK().fun(nums, nums[0]));
    }
}
class GetNumberOfK {
    public int fun(int [] nums , int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int L = 0;
        int R = nums.length - 1;
        int mid = -1;
        while(L <= R){
            mid = L + (R - L)/2;
            if(nums[mid] < k){
                L = mid + 1;
            }else if(nums[mid] > k){
                R = mid - 1;
            }else{
                if(nums[L] == k && nums[R] == k){
                    break;
                }
                if(nums[L] != k){
                    L++;
                }
                if(nums[R] != k){
                    R--;
                }

            }
        }
        return L > R ? 0 : R - L + 1;
    }
}