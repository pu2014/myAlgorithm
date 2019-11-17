package com.pu.数组;

/**
 * 局部最小的概念，arr长度为1时，arr[0]为局部最小  N>1时，arr[0]<arr[1] arr[0]为
 * 局部最小，arr[N-1]<arr[N-2] arr[N-2] 局部最小
 * arr[i] < arr[i+1]  arr[i] < arr[i - 1]  arr[i]局部最小
 * arr无相等的数，无序
 *
 * 函数要求：只需要返回arr中任意一个局部最小的位置即可
 */
public class 在数组中找到一个局部最小的位置 {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1,6,7};
        System.out.println(getLocalMinimum(arr));
        System.out.println(getLocalMinimumNew(arr));
    }

    public static String getLocalMinimumNew(int[] arr){
        if(arr == null || arr.length == 0){
            return "array is null";
        }
        if(arr.length == 1 || arr[0] < arr[1] ){
            return "arr[0]";
        }
        if(arr[arr.length - 1] < arr[arr.length - 2]){
            return "arr[" + arr.length + (-1) + "]";
        }

        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while(left < right){
            mid = (left + right) >> 1;
            if(arr[mid] > arr[mid - 1]){
                right = mid - 1;
            }else if(arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else{
                break;
            }
        }
        return "arr[" + mid + "]";
    }

    public static String getLocalMinimum(int[] arr){
        if(arr.length == 1){
            return "arr[0]";
        }else{
            int pre = arr[0];
            int cur;
            int pos;
            for(int i = 0;i < arr.length - 1;i++){
                cur = arr[i];
                pos = arr[i+1];
                if(i == 0){
                    if(cur < pos){
                        return "arr[" + i + "]";
                    }
                }else{
                    pre = arr[i - 1];
                    if(cur < pos && cur < pre){
                        return "arr[" + i + "]";
                    }
                }
            }
        }
        return "No local minimum";
    }
}
