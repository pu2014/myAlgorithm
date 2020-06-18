package com.笔试.IEEE;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/14 11:14
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        Arrays.sort(nums,(o1, o2) -> {
            int[] c1 = Arrays.copyOf(o1, o1.length);
            int[] c2 = Arrays.copyOf(o2, o2.length);
            int res = fun(c1) - fun(c2);
            if(res > 0){
                return 1;
            }else if(res < 0){
                return -1;
            }else{
                return 0;
            }
        });
        System.out.println(Arrays.deepToString(nums));
    }
    public static int fun(int [] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }
    public static int mergeSort(int[] nums, int L, int R){
        if(L >= R){
            return 0;
        }
        int mid = L + (R - L)/2;
        return (mergeSort(nums,L,mid)
                + mergeSort(nums,mid + 1,R)
                + merge(nums, L, mid, R));
    }
    public static int merge(int[] nums, int L, int mid, int R){
        int[] ex = new int[R - L + 1];
        int pL = L;
        int pR = mid + 1;
        int inx = 0;
        int count = 0;
        while(pL <= mid && pR <= R){
            if(nums[pL] > nums[pR]){
                count = (count + mid - pL + 1);
                ex[inx++] = nums[pR++];
            }else{
                ex[inx++] = nums[pL++];
            }
        }
        while(pL <= mid){
            ex[inx++] = nums[pL++];
        }
        while(pR <= R){
            ex[inx++] = nums[pR++];
        }
        for(int i = 0; i < ex.length; i++){
            nums[L + i] = ex[i];
        }
        return count;
    }
}
