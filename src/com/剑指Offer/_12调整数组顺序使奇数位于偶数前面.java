package com.剑指Offer;

import com.tools.MyArrays;
import com.tools.Print;

import java.util.Arrays;

/**
 * description：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author Pubojian
 * @date 2020/3/8 8:52
 */
public class _12调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args){
        int[] arr = MyArrays.createArray(20);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        Print.printArray(arr);
        new ReorderArray().reOrderArray1(arr);
        Print.printArray(arr);


        Print.printArray(arr2);
        new ReorderArray().reOrderArray2(arr2);
        Print.printArray(arr2);
    }
}
class ReorderArray{
    /**
     * 利用2 * length数组依此取
     * @param array
     */
    public void reOrderArray1(int[] array) {
        if(array == null || array.length == 0){
            return;
        }
        int m = 0;
        int len = array.length;
        int[] newArray = new int[len];
        for(int i = 0; i < array.length; i++){
            if((array[i] & 1) == 1) {
                newArray[m++] = array[i];
            }
        }
        for(int i = 0; i < array.length; i++){
            if((array[i] & 1) == 0) {
                newArray[m++] = array[i];
            }
        }
        m = 0;
        for(int i = 0; i < len; i++){
            array[m++] = newArray[i];
        }
    }

    /**
     * 通过先找到奇数值，交换到前面去 （类似插入排序）
     * @param array
     */
    public void reOrderArray2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int even = 0;
        for (int odd = 0; odd < array.length; odd++) {
            //寻找奇数
            if((array[odd] & 1) == 1){
                int temp = array[odd];
                int cur = odd;
                while(cur > even){
                    array[cur] = array[cur - 1];
                    cur--;
                }
                even = cur + 1;
                array[cur] = temp;
            }

        }
    }
}
