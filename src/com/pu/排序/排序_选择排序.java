package com.pu.排序;

/**
 * 复杂度：n + (n - 1) + ... n(n + 1)/2  O(n^2)
 * 空间复杂度：O（1）
 * 稳定性 稳定
 */

import java.util.Arrays;

public class 排序_选择排序 {
    public static void main(String[] args) {
        int a = 1,b = 2;
        swap3(a,b);
        //swap2(a,b);
        System.out.println(a);
        int[] arr = {12,3,54,76,59,80,38,6,50,24,20,4,82};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        if(arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[i]){
                    swap(arr,i,j);
                }
            }
        }
    }

    private static void swap(int[] arr,int i, int j){
        //^异或符号
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    //java 只有值传递，没有引用传递

    /**
     * java的值传递 Java里方法的参数传递方式只有一种：值传递。值传递，
     * 就是将实际参数值的副本（复制品）传入方法内，而参数本身不会受到任何影响。
     * @1  形参是基本类型的，将实参的值传递给形参的基本数据类型的变量。
     * @2  形参是引用数据类型的，将实参的引用类型的值（对象的首地址）传递给形参。
     *
     * Java数据类型在内存中的存储：
     *
     * 1）基本数据类型的存储原理：所有的简单数据类型不存在“引用”的概念，基本数据类型都
     * 是直接存储在内存中的内存栈上的，数据本身的值就是存储在栈空间里面，而Java语言里
     * 面八种数据类型是这种存储模型；
     *
     * 2）引用类型的存储原理:引用类型继承于Object类（也是引用类型）都是按照Java里
     * 面存储对象的内存模型来进行数据存储的，使用Java内存堆和内存栈来进行这种类型的
     * 数据存储，简单地讲，“引用”是存储在有序的内存栈上的，而对象本身的值存储在内存堆上的；
     *
     */
    private static void swap2(int a ,int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

    }
    private static void swap3(int a,int b){
        a = a + b;
        b = a - b;
        a = a - b;
    }

}
