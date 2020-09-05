package com.笔试.sougou;

import java.util.Arrays;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/5 19:00
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(numberofprize(4,4,2));
        System.out.println(numberofprize(7,4,2));
        System.out.println(numberofprize(9,4,2));
        System.out.println(numberofprize(9,4,3));
        System.out.println(numberofprize(8,4,3));
    }

    private static int numberofprize(int a, int b, int c) {
        int[] nums = {a,b,c};
        Arrays.sort(nums);
        if(nums[2] - nums[1] >= 2){
            return numberofprize(nums[0] + 1, nums[1], nums[2] - 2);
        }
        if(nums[1] - nums[0] >= 2){
            return numberofprize(nums[0] + 1, nums[1] - 1, nums[2] - 1);
        }
        return nums[0];
    }
}
