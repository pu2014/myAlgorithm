package com.分类题型.单调栈;

import com.tools.Print;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/9 14:03
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {3,2,5,6,7,5,5,3,6,7,8,9,0,5,4,6,6};
        System.out.println(maxInWindows(nums, 3));
        Print.printArray(nums);
        System.out.println(maxInWindowsByLinkedList(nums, 3));


    }

    private static ArrayList<Integer> maxInWindowsByLinkedList(int[] num, int w) {
        /**
         * Description:利用双向单调队列实现
         * @auther
         */
        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length < w || w <= 0){
            return res;
        }
        LinkedList<Integer> wQ = new LinkedList<>();
        for(int i = 0; i < num.length; i++){
            while(!wQ.isEmpty() && num[wQ.peekLast()] <= num[i]){
                wQ.pollLast();
            }
            wQ.addLast(i);
            if(wQ.peekFirst() == i - w){
                wQ.pollFirst();
            }
            if(i >= w - 1){
                res.add(num[wQ.peekFirst()]);
            }
        }
        return res;
    }

    public static  ArrayList<Integer> maxInWindows(int [] num, int size){
        /**
         * Description:自己刷题时候想的办法，最差时间复杂度O(N^2) 最好时间复杂度O(N)
         * @auther pbj
         */
        ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length < size || size <= 0){
            return list;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            if(num[i] > max){
                max = num[i];
            }
        }
        list.add(max);
        for(int i = size; i < num.length; i++){
            if(num[i] >= max){
                max = num[i];
            }else{
                max = num[i];
                for(int k = i - 1; k > i - size; k--){
                    if(num[k] > max){
                        max = num[k];
                    }
                }
            }
            list.add(max);
        }
        return list;
    }
}
