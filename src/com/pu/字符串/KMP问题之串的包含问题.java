package com.pu.字符串;

import java.util.Arrays;

/**
 * description：KMP问题：求解串之间的包含问题。
 * getIndexOf(String str1, String str2)返回str2在str1中出现的第一个位置，
 *  没出现则返回-1.
 *
 * @author Pubojian
 * @date 2020/1/31 21:52
 */
public class KMP问题之串的包含问题 {
    public static void main(String[] args) {
        String str1 = "abcabcababaccc";
        String str2 = "ababa";
        int[] next = getNextArray(str2);
        System.out.println(Arrays.toString(next));
        int index = getIndexOf(str1, str2);
        System.out.println(index);
    }

    private static int getIndexOf(String str1, String str2) {
        if(str1 == null || str2 == null || str2.length() < 1 || str1.length() < str2.length()){
            return -1;
        }
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while(i1 < str1.length() && i2 < str2.length()){
            if(str1.charAt(i1) == str2.charAt(i2)){
                i1++;
                i2++;
            }else if(next[i2] == -1){
                i1++;
            }else{
                i2 = next[i2];
            }
        }
        return i2 == str2.length() ? i1 - i2 : -1;
    }

    private static int[] getNextArray(String str2) {
        if(str2.length() == 1){
            return new int[] {-1};
        }
        int[] next = new int[str2.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while(i < next.length){
            if(str2.charAt(i - 1) == str2.charAt(cn)){
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }
}
