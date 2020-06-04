package com.分类题型.数组.旋转数组;

import com.tools.MyInput;
import com.tools.Print;

/**
 * Description: 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * Created By @Author my on @Date 2020/5/28 16:03
 */
public class _33搜索旋转排序数组 {
    public static void main(String[] args) {
        int target = MyInput.inputInt();
        int[] nums = MyInput.inputArray();
        Print.printArray(nums);
        SearchArrayTarget proc = new SearchArrayTarget();
        System.out.println(proc.search(nums, target));
    }
}
class SearchArrayTarget {
    /**
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int L = 0;
        int R = nums.length - 1;
        if(L == R){
            return nums[0] == target ? 0 : -1;
        }
        int mid;

        while(L < R){
            if(nums[L] == target){
                return L;
            }
            if(nums[R] == target){
                return R;
            }
            mid = L + (R - L)/2;
            if(nums[mid] == target){
                return mid;
            }
            //无重复元素  L - mid有序
            if(nums[mid] > nums[L]){
                //有序里面
                if(target > nums[L] && target < nums[mid]){
                    R = mid - 1;
                }else{
                    L = mid + 1;
                }
            }else{
                if(target < nums[R] && target > nums[mid]){
                    L = mid + 1;
                }else {
                    R = mid - 1;
                }
            }
        }
        return -1;
    }
}
