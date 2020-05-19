package com.剑指Offer;

import com.tools.Print;

import java.util.Scanner;

/**
 * @DESC    在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 1,2,3,4,5,6,7,0  out: 7
 * @CREATE BY @Author pbj on @Date 2020/5/19 10:35
 */
public class _34数组中的逆序对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
             nums[i] = sc.nextInt();
        }
        Print.out(new InversePairs().fun(nums));

    }
}
class InversePairs {
    public int fun(int [] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }
    public int mergeSort(int[] nums, int L, int R){
        if(L >= R){
            return 0;
        }
        int mid = L + (R - L)/2;
        return (mergeSort(nums,L,mid)
        + mergeSort(nums,mid + 1,R)
        + merge(nums, L, mid, R)) % 1000000007;
    }
    public int merge(int[] nums, int L, int mid, int R){
        int[] ex = new int[R - L + 1];
        int pL = L;
        int pR = mid + 1;
        int inx = 0;
        int count = 0;
        while(pL <= mid && pR <= R){
            if(nums[pL] > nums[pR]){
                count = (count + mid - pL + 1) % 1000000007;
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
