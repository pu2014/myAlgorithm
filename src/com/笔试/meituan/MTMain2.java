package com.笔试.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @DESC 5
 * 3 2 4 4 5
 * 4 3 5 2 1
 * 样例输出
 * 9
 * 5
 * 5
 * 3
 * 0
 * @CREATE BY @Author pbj on @Date 2020/8/22 16:24
 */
public class MTMain2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numsStr = br.readLine().trim().split(" ");
        String[] inputStr = br.readLine().trim().split(" ");
        int[] nums = Arrays.stream(numsStr).mapToInt(Integer::valueOf).toArray();
        int[] input = Arrays.stream(inputStr).mapToInt(Integer::valueOf).toArray();
        for(int i = 0; i < n; i++){
            nums[input[i] - 1] = 0;
            System.out.println(process(nums));
        }

    }

    private static int process(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(cur != 0){
                i++;
                for(; i < nums.length; i++){
                    if(nums[i] != 0){
                        cur += nums[i];
                    }else{
                        break;
                    }
                }
                if(max < cur){
                    max = cur;
                }
            }
        }
        return max;
    }
}
