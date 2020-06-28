package com.分类题型.滑动窗口法;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 * Created By @Author给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 my on @Date 2020/6/27 22:33
 */
public class _239滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(nums, k)));
    }
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> deque = new LinkedList<>();
            int[] res = new int[nums.length - k + 1];
            for(int right = 0; right < nums.length; right++){
                while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]){
                    deque.pollLast();
                }
                deque.addLast(right);
                while(right - deque.peekFirst() >= k){
                    deque.pollFirst();
                }
                if(right >= k - 1){
                    res[right - k + 1] = nums[deque.peekFirst()];
                }
            }
            return res;
        }
    }
}
