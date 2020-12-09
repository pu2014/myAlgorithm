package com.ZuoShen.stack;

/**
 * @DESC 给定一个有序数组arr，调整arr使得这个数组的左半部分[1, \frac{n+1}{2}][1,
 * 2
 * n+1
 * ​
 *  ]没有重复元素且升序，而不用保证右部分是否有序
 * 例如，arr = [1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9]，调整之后arr=[1, 2, 3, 4, 5, 6, 7, 8, 9, .....]。
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 * @CREATE BY @Author pbj on @Date 2020/12/9 14:24
 */
public class CD_36数组部分排序 {
    public static void main(String[] args) {
        int n = 16;
        int[] nums = {1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9};
        method(n, nums);
    }

    public static void method(int N, int[] nums){
        int slow = 0;
        for(int fast = 1; fast < N; fast++){
            if(nums[slow] != nums[fast]){
                slow++;
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
            }
        }
        System.out.print(nums[0]);
        for(int i = 1; i < N; i++){
            System.out.print(" " + nums[i]);
        }
        System.out.println();
    }
}
