package com.pu.递归;

public class 递归求最大值 {
    private static int  getMax(int[] arr,int L,int R){
        if(L == R){
            return arr[L];
        }
        int mid = (L + R) >> 1;
        return getMax(arr,L,mid) > getMax(arr,mid + 1,R) ? getMax(arr,L,mid) : getMax(arr,mid + 1,R);
    }
    public static void main(String[] args) {
        int[] arr = {3,5,7,1,0};
        int max = getMax(arr,0,arr.length - 1);
        System.out.println(max);
    }
}
