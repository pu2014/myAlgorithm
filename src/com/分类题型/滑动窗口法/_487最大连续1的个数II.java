package com.分类题型.滑动窗口法;

import com.tools.MyInput;

/**
 * @DESC 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 *
 * 示例 1：
 *
 * 输入：[1,0,1,1,0]
 * 输出：4
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 *      当翻转以后，最大连续 1 的个数为 4。
 * 注：
 * 输入数组只包含 0 和 1.
 * 输入数组的长度为正整数，且不超过 10,000
 * ————————————————
 * 如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？
 * 版权声明：本文为CSDN博主「tankpanv」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/tankpanv/article/details/99680166
 * @CREATE BY @Author pbj on @Date 2020/6/23 15:35
 */
public class _487最大连续1的个数II {
    public static void main(String[] args) {
        int[] ints = MyInput.inputArray();
        System.out.println(new Solution().findMaxConsecutiveOnes(ints));
    }
    static class Solution{
        //无限流的长度逐个输入。即空间O(1)
        public int findMaxConsecutiveOnes(int[] nums){
            int zero = 0;
            int max = 0;
            int left = 0;
            int right = 0;
            while(right < nums.length){
                if(nums[right] == 0){
                    zero++;
                }
                while(zero > 1){ //超过一个需要滑动left
                    if(nums[left++] == 0){
                        zero--;
                    }
                }
                max = Math.max(max, right - left + 1);
                right++;
            }
            return max;
        }
    }
}
