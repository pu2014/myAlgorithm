package com.pu.数组;

/**
 * description：给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Pubojian
 * @date 2019/12/13 21:31
 */
public class 删除排序数组中的重复项 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicatesVer1(nums));
        for(Integer i : nums){
            System.out.print(i + " ");
        }
        System.out.println("*************");
        System.out.println(removeDuplicatesVer2(nums));
        for(Integer i : nums){
            System.out.print(i + " ");
        }
        System.out.println("*************");
        System.out.println(removeDuplicatesVer3(nums));
        for(Integer i : nums){
            System.out.print(i + " ");
        }
        System.out.println("*************");

    }

    private static int removeDuplicatesVer3(int[] nums) {
        /**
         * Description:直接赋值o（n）
         * @auther leetcode
         */
        if(nums.length == 0){
            return 0;
        }
        int res = 0; //慢指针
        for (int i = 1; i < nums.length; i++) { //i快指针
            if(nums[i] != nums[res]){
                res++;
                nums[res] = nums[i];
            }
        }
        return res + 1;
    }

    private static int removeDuplicatesVer2(int[] nums) {
        /**
         * Description:使用min代替重复值再交换
         * @auther pubojian
         */
        if(nums == null){
            return 0;
        }
        int len = nums.length;
        if(len < 2){
            return len;
        }
        int fast = 1;
        int slow = 0;
        //第一次  把重复值变为min
        while(fast < len){
            if(nums[fast] > nums[slow]){//大于就都移动
                slow = fast;
                fast++;
            }else{//等于把等于的变为min
                nums[fast] = Integer.MIN_VALUE;
                fast++;
            }
        }
        //第二次，min往后交换
        fast = 0;
        slow = 0;
        while(fast < len){
            if(nums[slow] != Integer.MIN_VALUE && nums[fast] != Integer.MIN_VALUE){
                slow++;
                fast++;
            }else if(nums[slow] == Integer.MIN_VALUE && nums[fast] == Integer.MIN_VALUE){
                fast++;
            }else{
                swap(nums, slow, fast);
                slow++;
                fast++;
            }
        }
        return slow;
    }

    private static int removeDuplicatesVer1(int[] nums) {
        /**
         * Description:时间复杂度较大的算法，每次遇到重复就直接后面一个前移。
         * @auther pubojian
         */
        if(nums == null){
            return 0;
        }
        if(nums.length < 2){
            return nums.length;
        }
        int res = 1;
        int i = 1;
        int k = nums.length;
        while(i < k){
            if(nums[i - 1] < nums[i]){
                res++;
                i++;
            }else if(nums[i] == nums[i - 1]){
                for(int j = i; j < k - 1; j++){
                    swap(nums, j, j + 1);
                }
                k--;
            }else{
                break;
            }
        }
        return res;
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
