package com.pu.字符串;

/**
 * @Description:给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * @Author: pubojian
 * @Date: Created in 20:13 2019/11/21
 **/
public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "lacadafajdjhjkkjhjd";
        String s2 = "babad";
        System.out.println(longestPalindromeV1(s));
        System.out.println(longestPalindromeV2(s2));
    }

    private static String longestPalindromeV2(String s) {
        /**
         *@Description：对1进行优化,不使用那么多数组。
         *@Author: pubojian
         *@Date: 2019/11/21 20:30
         **/
        if(s == null || s.length() < 2){
            return s;
        }
        String res = s.substring(0,1);
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length() - 1; j >= i; j--) {
                if (isHuiWen(s, i, j)) {
                    if ((j - i + 1) > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return res;
    }

    private static String longestPalindromeV1(String s) {
        /**
         *@Description：采用类似穷举法
         *@Author: pubojian
         *@Date: 2019/11/21 20:28
         **/
        if(s == null || s.length() < 2){
            return s;
        }
        char[] chs = s.toCharArray();
        int[] arr = {0,0};
        String res = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length() - 1; j >= i; j--){
                if(isHuiWen(chs, i, j)){
                    if((arr[1] - arr[0]) < (j - i)) {
                        arr[0] = i;
                        arr[1] = j;
                    }
                    break;
                }
            }
        }
        for(int i = arr[0]; i <= arr[1]; i++){
            res += chs[i];
        }
        return res;
    }
    private static boolean isHuiWen(char[] chs, int i, int j){
        while(i < j){
            if(chs[i] == chs[j]){
                j--;
                i++;
            }else{
                return false;
            }

        }
        return true;
    }

    private static boolean isHuiWen(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                j--;
                i++;
            }else{
                return false;
            }

        }
        return true;
    }
}
