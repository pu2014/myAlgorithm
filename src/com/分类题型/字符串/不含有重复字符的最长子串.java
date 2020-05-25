package com.分类题型.字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * description：
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * @author Pubojian
 * @date 2019/11/19 10:46
 */
public class 不含有重复字符的最长子串 {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring4ms(str));
        System.out.println(lengthOfLongestSubstring2ms(str));
        System.out.println(lengthOfLongestSubstringBySlidingWindow1(str));
        System.out.println(lengthOfLongestSubstringBySlidingWindow2(str));
    }

    private static int lengthOfLongestSubstringBySlidingWindow2(String str) {
        /**
         *@Description：滑动窗口法实现v2.0  O(N)  hashmap
         *@Author: leetcode
         *@Date: 2019/11/19 21:11
         **/
        int len = str.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0,i = 0; j < len; j++){
            if(map.containsKey(str.charAt(j))){
                i = Math.max(map.get(str.charAt(j)),i);
            }
            max = Math.max(max, j - i + 1);
            map.put(str.charAt(j), j + 1);
        }
        return max;
    }

    private static int lengthOfLongestSubstringBySlidingWindow1(String str) {
        /**
         *@Description：滑动窗口法实现v1.0  O(2N)  hashset
         *@Author: leetcode
         *@Date: 2019/11/19 21:05
         **/
        int len = str.length();
        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while(i < len && j < len){
            if(!set.contains(str.charAt(j))){
                set.add(str.charAt(j++));
                max = Math.max(max, j - i);
            }else{
                set.remove(str.charAt(i++));
            }
        }
        return max;
    }

    private static int lengthOfLongestSubstring2ms(String str) {
        char[] chs = str.toCharArray();
        int i = 0, max = 0;
        for(int j = 0; j < chs.length; j++){
            for(int k = i; k < j; k++){
                if(chs[k] == chs[j]){
                    i = k + 1;
                    break;
                }
            }
            if(j - i + 1 > max){
                max = j - i + 1;
            }
        }
        return max;
    }

    public static  int lengthOfLongestSubstring4ms(String s) {
        /**
         * Description:4ms test
         * @auther Pubojian
         */
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        char[] chs = s.toCharArray();
        int len = chs.length;
        int start = 0;
        int end = start + 1;
        int max = 1;

        while(end < len){
            int res = isHas(chs, start, end);
            if(res == -1){
                end++;
            }else{
                start = res + 1;
                end++;
            }
            max = isMax(max, end - start);
        }
        return max;

    }
    public static int isHas(char[] arr, int start, int end){
        for(int i = start; i < end; i++){
            if(arr[i] == arr[end]){
                return i;
            }
        }
        return -1;
    }

    public static int isMax(int i, int j){
        return i > j ? i : j;
    }
}
