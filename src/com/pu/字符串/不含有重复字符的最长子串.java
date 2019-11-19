package com.pu.字符串;

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
