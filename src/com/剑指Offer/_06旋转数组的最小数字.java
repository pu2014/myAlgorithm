package com.剑指Offer;

import com.tools.MyArrays;
import com.tools.Print;

import java.awt.print.Printable;

/**
 * description：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author Pubojian
 * @date 2020/2/29 14:41
 */
public class _06旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        Solution s = new Solution();
        System.out.println(s.minNumberInRotateArray(arr));

    }
}
class Solution {
    public int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int L = 0;
        int R = array.length - 1;
        int M = 0;
        while(L < R){
            if (array[L] < array[R]) {
                return array[L];
            }
            M = L + ((R - L) >> 1);
            if(array[M] > array[L]){
                L = M + 1;
            }else if(array[M] < array[R]){
                R = M;
            }else{
                L++;
            }
        }
        return array[L];
    }
}
