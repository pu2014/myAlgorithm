package com.剑指Offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @DESC    输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *           例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @CREATE BY @Author pbj on @Date 2020/5/18 16:48
 */
public class _31把数组排成最小的数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(new PrintMinNumber().fun(nums));

    }
}

/**
 * @CREATE BY @Author pbj on @Date 2020/5/18 16:48
 */
class PrintMinNumber {
    public String fun(int [] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        String res = "";
        int temp = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(Integer.valueOf(nums[i] + "" + nums[j]) > Integer.valueOf(nums[j] + "" + nums[i])){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for(int num : nums){
            res += num;
        }
        return res;
    }

    public String minNumber(int[] nums) {
        //字典序排序
        if(nums.length == 0){
            return "";
        }
        StringBuilder[] strs = new StringBuilder[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = new StringBuilder(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs, (o1,o2)->(o1.append(o2)).toString().compareTo(o2.append(o1).toString()));
        for(StringBuilder str : strs){
            sb.append(str);
        }
        return sb.toString();
    }
}