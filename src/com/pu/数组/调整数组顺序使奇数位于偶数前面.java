package com.pu.数组;

/**
 * description：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *  使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 *  并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author Pubojian
 * @date 2020/1/3 20:56
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        reOrderArrayV1(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] arr1 = {1,2,3,4,5,6,7,8,9};

        reOrderArrayV2(arr1);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void reOrderArrayV2(int[] array) {
        /**
         * Description:先找到奇数，再从前找偶数。也就是每一次的奇数放前面，偶数依次后移。
         * @auther newCoder
         */
        if(array == null || array.length == 0){
            return;
        }
        int m = 0;//记录前一次最末尾奇数的位置
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if(array[i] % 2 == 1){//为奇数，往前找偶数
                int temp = array[i];
                int j = i;
                while(j > m){
                    array[j] = array[j - 1];
                    j--;
                }
                m = j + 1;
                array[j] = temp;
            }
        }
    }

    private static void reOrderArrayV1(int[] array) {
        /**
         * Description:先找到偶数，再从后找到第一个奇数，再依次交换过来。
         * @auther pubojian
         */
        if(array == null || array.length == 0){
            return;
        }
        int i = 0;//偶数指针
        int j = 0;//奇数指针
        int len = array.length;
        while(i < len){
            if(array[i] % 2 == 0){//找到偶数，判断其后面的奇数
                j = i + 1;
                while(j < len){
                    if(array[j] % 2 == 1){
                        int temp = array[j];
                        while(j > i){
                            array[j] = array[j - 1];
                            j--;
                        }
                        array[i] = temp;
                        break;
                    }
                    j++;
                }
            }
            i++;
        }
    }
}
