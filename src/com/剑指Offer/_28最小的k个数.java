package com.剑指Offer;

import com.tools.MyArrays;
import com.tools.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Description:
 * 输入n个整数，找出其中最小的K个数。
 * （大根堆）
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * Created By @Author my on @Date 2020/4/21 17:36
 */
public class _28最小的k个数 {
    public static void main(String[] args) {
        int[] nums = MyArrays.createArray(20);
        Print.printArray(nums);
        GetLeastNumbers_Solution fun = new GetLeastNumbers_Solution();
        System.out.println(fun.topK_1(nums, 5));

    }
}
class GetLeastNumbers_Solution {
    public ArrayList<Integer> topK_1(int[] input, int k) {
        if (input == null || input.length < k || k < 1) {
            return new ArrayList<>();
        }
        //构建大根堆
        Integer[] help = new Integer[k];

        for (int i = 0; i < k; i++) {
            help[i] = input[i];
        }
        for(int i = k/2 - 1; i >= 0; i--){
            adjustMaxHeap(help, i);
        }

        for(int i = k; i < input.length; i++){
            if(input[i] < help[0]){
                help[0] = input[i];
                adjustMaxHeap(help, 0);
            }
        }
        return new ArrayList<>(Arrays.asList(help));

    }

    private void adjustMaxHeap(Integer[] help, int cur) {
        //从0号排序,左孩子就是2*i+1
        int left = cur * 2 + 1;
        int right = left + 1;
        while (left < help.length) {
            int largest = right < help.length && help[right] > help[left] ? right : left;
            if(help[largest] < help[cur]){
                break;
            }
            swap(help,largest,cur);
            cur = largest;
            left = cur * 2 + 1;
            right = left + 1;
        }
    }

    private void swap(Integer[] help, int largest, int cur) {
        int tmp = help[largest];
        help[largest] = help[cur];
        help[cur] = tmp;
    }
}
