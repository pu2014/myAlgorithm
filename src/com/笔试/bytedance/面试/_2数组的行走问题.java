package com.笔试.bytedance.面试;
import java.util.*;
/**
 * @DESC 算法题(leetcode55题)：给一个数组，例如[1,2,3,4,5]，a[i]表示在该位置可以向前行走的最大距离，
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 判断是否可以到达数组的最后一个元素。
 * @CREATE BY @Author pbj on @Date 2020/7/28 9:16
 */
public class _2数组的行走问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        /**
         * 思路： 贪心算法，计算每一步能跳到的最远位置，如果当前位置大于最大位置，说明有0；到不了最后
         */
        int max = 0;
        for(int i = 0; i < n; i++){
            if(i > max || max >= n - 1) {
                break;
            }
            //贪心，每个点的最大值
            max = Math.max(max, i + nums[i]);
        }
        System.out.println(max >= n - 1 ? "yes" : "no");
    }
}
