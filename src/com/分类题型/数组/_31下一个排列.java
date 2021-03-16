package com.分类题型.数组;

import com.tools.Print;

import java.util.Arrays;

/**
 * @DESC实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2021/3/13 13:19
 */
public class _31下一个排列 {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        Print.printArray(nums);
    }
}
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int right = nums.length - 1;
        while(right > 0 && nums[right] <= nums[right - 1]){
            right--;
        }
        if(right == 0){
            Arrays.sort(nums);
        }else{
            right--;
            int i = nums.length - 1;
            while(i > right && nums[i] <= nums[right]){
                i--;
            }
            swap(nums, i, right);
            Arrays.sort(nums, right + 1, nums.length);
        }

    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}