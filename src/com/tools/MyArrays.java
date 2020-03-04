package com.tools;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/29 14:44
 */
public class MyArrays {
    public static int[] sortArray(){
        return new int[]{1,2,3,3,4,5,5,6,6,7,7,7};
    }

    public static int[] createArray(int len){
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            res[i] = (int)(Math.random()*(10));
        }
        return res;
    }
}
