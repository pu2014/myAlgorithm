package com.笔试.xiaohongshu;

import com.tools.Tree;
import com.tools.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/12 10:21
 */
public class Main1 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,7,6};
        System.out.println(exist(nums));
    }
    public static int exist(int[] nums){
        if(nums == null || nums.length == 0){
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int res = 1;
        while(true){
            if(set.contains(res)){
                res++;
            }else{
                return res;
            }
        }
    }

}
