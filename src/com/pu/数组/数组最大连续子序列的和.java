package com.pu.数组;

/**
 * description：题目是：HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子
 * 向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,
 * 是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，
 * 返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * @author Pubojian
 * @date 2019/12/24 15:10
 */
public class 数组最大连续子序列的和 {
    public static void main(String[] args) {
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(findGreatestSumOfSubArray(arr));

    }
    public static int findGreatestSumOfSubArray(int[] array) {
        /**
         * Description://设置指针从0开始向右移动，如果当前指针 + 前面指针代表的和为sum，计算max
         *         //如果sum > 0 移动 sum = sum
         *         //如果素sum < 0 移动 sum归零
         * @auther pubojian
         */
        if(array == null){
            return 0;
        }
        int i = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while(i < array.length){
            sum = array[i] + sum;
            max = max > sum ? max : sum;
            if(sum < 0){
                sum = 0;
            }
            i++;

        }
        return max;
    }
}
