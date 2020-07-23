package com.分类题型.数组;

import java.util.Stack;

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
        System.out.println(new Trap().trap(nums));
        System.out.println(new Trap().methodByStack(nums));
    }
}
class Trap {
    /**
     * 用较小的值 存水
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height.length < 3) return 0;

        int left = 0, right = height.length - 1;
        int leftmax = height[left], rightmax = height[right];
        int res = 0;

        while(left < right){
            if(leftmax < rightmax){
                res += leftmax - height[left++];
                leftmax = Math.max(height[left], leftmax);
            }else{
                res += rightmax - height[right--];
                rightmax = Math.max(height[right], rightmax);
            }
        }

        return res;
    }
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

    /**
     * 单调栈方法  里面元素单调递减
     * @param height
     * @return
     */
    public int methodByStack(int[] height){
        if(height.length < 3) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                //如果栈中元素小于当前高度，弹出
                Integer pre = stack.pop();
                //相同元素 pass
                while(!stack.isEmpty() && height[stack.peek()] == height[pre]){
                    stack.pop();
                }
                //找到形成凹槽的点  2 1 3  也就是peek() pre height[i] 形成凹槽
                if(!stack.isEmpty()){
                    res += (Math.min(height[i], height[stack.peek()]) - height[pre]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }
}
