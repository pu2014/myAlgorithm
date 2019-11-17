package com.pu.数组;

import java.util.Arrays;

public class 荷兰旗问题 {
    public static void main(String[] args) {
        int[] arr = {3,4,4,5,6,4,5,3,6,7,5,3};
        int pivot = 3;
        int left = 0;
        int right = arr.length - 1;
        partition(arr,0,right,3);
        System.out.println(Arrays.toString(arr));
        /*int i = 0;
        while (left < right) {
            if (arr[i] < pivot) {
                swap(arr, i++, ++left);
            } else if (arr[i] > pivot) {
                swap(arr, i, --right);
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));*/
    }
    public static int[] partition(int[] arr, int L, int R, int p) {
        int less = L;
        int more = R;
        while(L < more) {
            if(arr[L] < p) {
                swap1(arr, less++, L++);
            } else if (arr[L] > p) {
                swap1(arr, more--, L);
            } else {
                L++;
            }
        }
        return new int[] { less + 1, more - 1 };
    }
    private static void swap1(int[] arr,int i, int j){
        //^异或符号
        //当有相等的时候不行 会变成 0
        /*
        上面的三个 还会执行就是 1 = 1^ 1;执行三次 过程是这样的

		1 = 1 ^ 1  -->0
		0 = 0 ^ 0 -->0
		0 = 0 ^ 0 -->0
         */
        if(i == j){
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    private static void swap(int[] arr, int i, int j) {
       /* arr[i] = arr[i]  ^ arr[j];
        arr[j] = arr[i]  ^ arr[j];
        arr[i] = arr[i]  ^ arr[j];*/
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
