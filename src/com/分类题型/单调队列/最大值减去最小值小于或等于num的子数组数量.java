package com.分类题型.单调队列;

import java.util.LinkedList;

/**
 * description：双向单调队列实现最大值减去最小值小于或等于num的子数组数量
 *
 * @author Pubojian
 * @date 2020/2/9 15:09
 */
public class 最大值减去最小值小于或等于num的子数组数量 {
    public static void main(String[] args) {
        int[] arr = {3,2,5,1,6};
        int num = 4;
        System.out.println(getAllLessNumSubArrayByLinkedList(arr, num));
        System.out.println(getAllLessNumSubArray(arr, num));
    }

    private static int getAllLessNumSubArrayByLinkedList(int[] arr, int num) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();
        int L = 0;
        int R = 0;
        int res = 0;
        while(L < arr.length){
            while(R < arr.length){
                while(!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]){
                    qMax.pollLast();
                }
                qMax.addLast(R);
                while(!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[R]){
                    qMin.pollLast();
                }
                qMin.addLast(R);
                if(arr[qMax.getFirst()] - arr[qMin.getFirst()] > num){
                    break;
                }
                R++;
            }
            if(qMin.peekFirst() == L){ //下标过期
                qMin.pollFirst();
            }
            if(qMax.peekFirst() == L){
                qMax.pollFirst();
            }
            res += R - L;
            L++;
        }
        return res;
    }

    private static int getAllLessNumSubArray(int[] arr, int num) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                if(isValid(arr, i, j, num)){
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean isValid(int[] arr, int i, int j, int num) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            if(max < arr[k]){
                max = arr[k];
            }
            if(min > arr[k]){
                min = arr[k];
            }
        }
        return max - min <= num;
    }
}
