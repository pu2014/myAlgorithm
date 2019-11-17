package com.pu.递归;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 打印一个字符串的全部排列，要求不要出现重复的排列
 */
public class 打印一个字符串的全部排序 {
    public static void main(String[] args) {
        String str = "bad";
        printAllSub(str);
    }

    private static void printAllSub(String str) {
        char[] chs = str.toCharArray();
    }

    private static void process(char[] chs, int i) {
        if(i == chs.length){
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for(int j = i; j < chs.length; j++){
            if(!set.contains(chs[j])){
                set.add(chs[j]);
                swap(chs,i,j);
                process(chs,i + 1);
                swap(chs,i,j);
            }
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
