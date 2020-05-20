package com.剑指Offer;

import java.util.Scanner;

/**
 * @DESC 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不
 * 知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，
 * 如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @CREATE BY @Author pbj on @Date 2020/5/20 20:18
 */
public class _46数组中重复的数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        Duplicate proc = new Duplicate();
        System.out.println(proc.fun(nums));

    }
}
class Duplicate {
    public int fun(int numbers[]) {
        if(numbers == null || numbers.length == 0){
            return -1;
        }
        for(int i = 0; i < numbers.length; i++){
            int cur = numbers[i];
            if(cur != i){
                if(numbers[cur] == cur){
                    return cur;
                }else{
                    int temp = numbers[cur];
                    numbers[cur] = numbers[i];
                    numbers[i--] = temp;
                }
            }
        }
        return -1;
    }
}
