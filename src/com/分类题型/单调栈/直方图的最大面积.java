package com.分类题型.单调栈;

import java.util.Stack;

/**
 * description：单调栈的运用
 *
 * @author Pubojian
 * @date 2020/2/12 18:14
 */
public class 直方图的最大面积 {
    public static void main(String[] args) {
        int[] height = {1, 1, 0, 1};
        System.out.println(maxRectAreaFromBottom(height));
    }

    private static int maxRectAreaFromBottom(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, (i - k - 1) * height[j]);
                //System.out.println(j + ".." + max);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, (height.length - k - 1) * height[j]);
            System.out.println(j + ".." + max);
        }
        return max;
    }
}
