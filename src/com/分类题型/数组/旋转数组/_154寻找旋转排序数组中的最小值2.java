package com.分类题型.数组.旋转数组;

import com.tools.MyInput;
import com.tools.Print;

/**
 * Description:假设按照升序排序的数组在预先未知的某个点上进行了旋转
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created By @Author my on @Date 2020/5/28 15:34
 */
public class _154寻找旋转排序数组中的最小值2 {
    public static void main(String[] args) {
        int[] nums = MyInput.inputArray();
        Print.printArray(nums);
        FindArrayMin2 proc = new FindArrayMin2();
        System.out.println(proc.findMin(nums));
    }
}

class FindArrayMin2 {
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
                break;
            }
            mid = L + ((R - L) >> 1);
            //注意这里临界值的判断
            if(nums[mid] > nums[L]){
                L = mid + 1;
            }else if(nums[mid] < nums[R]){
                R = mid;
            }else{
                L++;
            }
        }
        return nums[L];
    }
}
