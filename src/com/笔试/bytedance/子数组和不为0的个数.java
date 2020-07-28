package com.笔试.bytedance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @DESC 子数组和不为0的个数
 * @CREATE BY @Author pbj on @Date 2020/7/25 11:11
 */
public class 子数组和不为0的个数 {
    public static void main(String[] args) throws IOException {
        int[] nums = {-1,0,2};
        System.out.println(method(nums));
    }
    public static int method(int[] nums){
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int cnt = 0;
        for(int num : nums){
            sum += num;
            if(set.contains(sum)){
                cnt++;
            }
            set.add(sum);
        }
        return (nums.length * (nums.length + 1)) /2 - cnt;
    }
}
