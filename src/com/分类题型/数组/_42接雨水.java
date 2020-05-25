package com.分类题型.数组;

/**
 * @DESC 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @CREATE BY @Author pbj on @Date 2020/5/13 11:28
 */
public class _42接雨水 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Trap().method1(nums));
    }
}
class Trap {
    public int method1(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int maxLeft = 0, maxRight = 0, sum = 0;
        for(int i = 1; i < height.length - 1; i++){
            maxLeft = 0;
            maxRight = 0;
            for(int j = i; j >= 0; j--){
                maxLeft = Math.max(height[j], maxLeft);
            }
            for(int j = i; j < height.length; j++){
                maxRight = Math.max(height[j], maxRight);
            }
            sum += Math.min(maxLeft, maxRight) - height[i];
        }
        return sum;
    }
}
