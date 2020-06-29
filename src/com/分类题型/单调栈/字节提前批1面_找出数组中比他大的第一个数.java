package com.分类题型.单调栈;

import com.tools.MyInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @DESC 找出数组中每个数右边第一个比它大的元素
 * 题目：给定一个整型数组，数组元素随机无序的，要求打印出所有元素右边第一个大于该元素的值。
 *
 * 如数组A=[1,5,3,6,4,8,9,10] 输出[5, 6, 6, 8, 8, 9, 10, -1]
 *
 * 如数组A=[8, 2, 5, 4, 3, 9, 7, 2, 5] 输出[9, 5, 9, 9, 9, -1, -1, 5, -1]
 * @CREATE BY @Author pbj on @Date 2020/6/29 16:15
 */
public class 字节提前批1面_找出数组中比他大的第一个数 {
    public static void main(String[] args) {
        int[] nums = {8, 2, 5, 4, 3, 9, 7, 2, 5};
        //  1 5 3 6 4 8 9 10
        System.out.println(Arrays.toString(new Solution().getNextMax(nums)));
    }
    static class Solution{
        private int[] getNextMax(int[] nums){
            if(nums == null || nums.length == 0){
                return nums;
            }
            int[] res = new int[nums.length];
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int i = 1;
            while(i < nums.length){
                while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                    res[stack.pop()] = nums[i];
                }
                stack.push(i++);
            }
            while(!stack.isEmpty()){
                res[stack.pop()] = -1;
            }
            return res;
        }
    }
}
