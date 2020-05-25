package com.剑指Offer;

import com.tools.Print;

import java.util.Scanner;

/**
 * @DESC  给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的
 * 元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * @CREATE BY @Author pbj on @Date 2020/5/20 21:15
 */
public class _47构建乘积数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        Multiply proc = new Multiply();
        Print.printArray(proc.fun(nums));
    }
}
class Multiply {
    public int[] fun(int[] A) {
        if(A == null || A.length == 0){
            return A;
        }
        int res = 1;
        int[] B = new int[A.length];
        for(int i = 0; i < A.length; i++){
            B[i] = res;
            res *= A[i];
        }
        res = 1;
        for(int i = A.length - 1; i >= 0; i--){
            B[i] *= res;
            res *= A[i];
        }
        return B;

    }
}

