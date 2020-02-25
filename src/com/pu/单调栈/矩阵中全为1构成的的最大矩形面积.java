package com.pu.单调栈;

import com.tools.Print;

import java.util.Stack;

/**
 * description：
 * 例如矩形
 * 1 1 0 1
 * 1 1 1 0
 * 0 1 1 1
 * 1 1 1 0
 * 最大矩形面积为 6
 * 1 1
 * 1 1
 * 1 1
 *
 * @author Pubojian
 * @date 2020/2/12 20:16
 */
public class 矩阵中全为1构成的的最大矩形面积 {
    public static void main(String[] args) {
        int[][] map = {
                {1, 1, 0, 1},
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0}
        };
        System.out.println(maxRectSize(map));
    }
    public static int maxRectSize(int[][] map){
        if(map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int max = 0;
        int[] help = new int[map[0].length];
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                help[j] = map[i][j] == 0 ? 0 : help[j] + 1;
            }
            //Print.printArray(help);
            max = Math.max(max, maxRectAreaFromBottom(help));
            //System.out.println(max);
        }
        return max;
    }
    public static int maxRectAreaFromBottom(int[] help){
        if(help == null || help.length == 0){
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < help.length; i++){
            while(!stack.isEmpty() && help[i] <= help[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, (i - k - 1) * help[j]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, (help.length - k - 1) * help[j]);
        }
        return max;
    }
}
