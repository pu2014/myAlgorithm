package com.分类题型.数组.旋转数组;

import com.tools.MyInput;
import com.tools.Print;

/**
 * Description:假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素你可以假设数组中不存在重复元素。
 * 示例 1:
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * Created By @Author my on @Date 2020/5/28 15:34
 */
public class _153寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        int[] nums = MyInput.inputArray();
        Print.printArray(nums);
        FindArrayMin proc = new FindArrayMin();
        System.out.println(proc.findMin(nums));
    }
}
class FindArrayMin {
    /**
     * [3,4,5,1,2]
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int L = 0;
        int R = nums.length - 1;
        int mid;
        while(L < R){
            if(nums[L] < nums[R]){
                return nums[L];
            }
            mid = L + (R - L)/2;
            if(nums[mid] >= nums[L]){
                L = mid + 1;
            }else if(nums[mid] <= nums[R]){
                R = mid;
            }else{
                L++;
            }
            /*
            if(nums[mid] >= nums[L]){
                L = mid + 1;
            }else{
                R = mid;
            }
             */
        }
        return nums[L];
    }
}
