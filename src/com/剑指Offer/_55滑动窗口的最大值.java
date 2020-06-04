package com.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @DESC  给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @CREATE BY @Author pbj on @Date 2020/5/22 20:46
 */
public class _55滑动窗口的最大值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] nums = new int[N];
        MaxInWindows proc = new MaxInWindows();
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(proc.fun(nums, M));
    }
}
class MaxInWindows {
    public ArrayList<Integer> fun(int [] nums, int size) {
        if(nums == null || nums.length < size || size < 1){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> deque = new LinkedList<>();
        int begin = 0;
        for(int i = 0; i < nums.length; i++){
            begin = i - size + 1;
            if(deque.isEmpty()){
                deque.addLast(i);
            }else if(begin > deque.peekFirst()){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            res.add(nums[deque.peekFirst()]);
        }
        return res;
    }
}