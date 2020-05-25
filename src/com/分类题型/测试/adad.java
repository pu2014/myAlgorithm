package com.分类题型.测试;

import java.util.HashSet;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/3/8 12:01
 */
public class adad {
    public static void main(String[] args) {
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        System.out.println(new Solution().numOfMinutes(15, -1, manager, informTime));
    }
}
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(manager == null || n == 0 || informTime == null){
            return 0;
        }
        if(n == 1) return informTime[0];
        HashSet<Integer> set = new HashSet<>();
        int timeCount = 0;
        int cur;
        for(int i = 0; i < n; i++){
            cur = manager[i];
            if(!set.contains(cur)){
                set.add(cur);
                timeCount += informTime[i];
            }
        }
        return timeCount;
    }
}