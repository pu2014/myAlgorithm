package com.分类题型.数组;

import com.tools.ListNode;
import com.tools.Print;

import java.util.Arrays;
import java.util.Scanner;

public class _416分割等和子集{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CanPartition proc = new CanPartition();
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] nums = new int[N];
            for(int i = 0; i < N; i++){
                nums[i] = sc.nextInt();
            }
            System.out.println(proc.fun(nums));
        }
    }
}
class CanPartition {
    boolean res = false;
    public boolean fun(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        Arrays.sort(nums);
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 == 0){
            dfs(nums, 0, sum/2);
        }
        return res;
    }

    public void dfs(int[] nums, int i, int sum){
        if(i == nums.length){
            return;
        }
        sum -= nums[i];
        if(sum == 0){
            res = true;
            return;
        }
        if(sum < 0){
            return;
        }
        //boolean res = false;
        for(int k = i + 1; k < nums.length; k++){
            dfs(nums, k, sum);
        }
    }
}