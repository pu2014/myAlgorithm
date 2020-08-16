package com.笔试.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/12 20:04
 */
public class WyMain1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        for(int k = 0; k < n; k++){
            String line = sc.nextLine().trim();
            boolean res = true;
            String[] strs = line.split(" ");
            int t = 0;
            int w = 0;
            int b = 0;
            for(String str : strs){
                if(str.contains("T")){
                    t++;
                }else if(str.contains("W")){
                    w++;
                }else{
                    b++;
                }
            }
            if(t > 3 || w > 3 || b > 3){
                System.out.println("NO");
                continue;
            }
            int[] nums = new int[7];
            for(int i = 0; i < strs.length; i++){
                nums[i] = strs[i].charAt(0) - '0';
            }
            Arrays.sort(nums);
            for(int i = 1; i < 7; i++){
                if(nums[i] == nums[i - 1]){
                    res = false;
                    break;
                }
            }
            System.out.println(res == true ? "YES" : "NO");
        }

    }
}
