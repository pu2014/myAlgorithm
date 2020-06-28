package com.分类题型.滑动窗口法;

import java.util.*;

/**
 * Description:
 * Created By @Author my on @Date 2020/6/27 22:20
 */
public class _3无重复字符的最长子串 {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(str));

    }
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            Map<Character, Integer> map = new HashMap();
            int res = 0;
            int max = 0;
            for(int right = 0; right < s.length(); right++){
                if(map.containsKey(s.charAt(right))){
                    max = Math.max(max, map.get(s.charAt(right)));
                }
                res = Math.max(res, right - max + 1);
                map.put(s.charAt(right), right + 1);
            }
            return res;
        }
    }
}
