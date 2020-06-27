package com.分类题型.滑动窗口法;

import com.tools.MyInput;

/**
 * @DESC 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/6/24 8:51
 */
public class _485最大连续1的个数 {
    public static void main(String[] args) {
        int[] nums = MyInput.inputArray();
        System.out.println(new Solution().findMaxConsecutiveOnes(nums));

    }
    static class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int left = 0;
            int right = 0;
            int max = 0;
            while(right < nums.length){
                while(right < nums.length && nums[right] == 1){
                    right++;
                }
                max = Math.max(right - left, max);
                while(right < nums.length && nums[right] == 0){
                    right++;
                }
                left = right;
            }
            return max;
        }
    }
}
