package com.分类题型.数组;

/**
 * @DESC 有序数组中返回数字的出现的位置
 * @CREATE BY @Author pbj on @Date 2020/9/12 16:37
 */
public class 猿辅导面试返回数字在数组中的位置 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,6,8,10};
        System.out.println(getTheNum(nums, 5));
        System.out.println(getTheNum(nums, 4));
        System.out.println(getTheNum(nums, 9));
    }

    private static int getTheNum(int[] nums, int target) {
        if(nums[0] > target){
            return -1;
        }else if(nums[nums.length - 1] < target){
            return nums.length;
        }
        int ll = 0;
        int rr = nums.length;
        int mid;
        while(ll < rr){
            mid = ll + (rr - ll) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(nums[mid] > target){
                rr = mid;
            }else{
                ll = mid;
                if(ll < nums.length - 1 && nums[ll + 1] == target){
                    return ll + 1;
                }else if(ll < nums.length - 1 && nums[ll + 1] > target){
                    return ll;
                }
            }
        }
        return ll;
    }
}
