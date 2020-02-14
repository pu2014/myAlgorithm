package com.pu.数组;

import java.util.HashMap;

/**
 * description：aim的变形题
 * 子数组之和为aim的最大长度基础上，奇数变为1；偶数变为-1.求aim为0的最大长度。
 *
 * @author Pubojian
 * @date 2020/2/14 21:27
 */
public class 子数组中奇数偶数相同的最大长度 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,7,7,7,7,7};
        System.out.println(getTheNums(nums));
    }

    private static int getTheNums(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] % 2 == 0 ? 1 : -1;
        }
        int sum = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                len = Math.max(len, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return len;
    }
}
