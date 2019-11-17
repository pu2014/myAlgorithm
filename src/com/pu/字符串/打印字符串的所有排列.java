package com.pu.字符串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * description：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则输出由
 * 字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 *
 * @author Pubojian
 * @date 2019/11/17 12:39
 */
public class 打印字符串的所有排列 {
    public static void main(String[] args) {
        String str = "aac";
        ArrayList<String> list;
        list = printAllSub(str);
        for(String string : list){
            System.out.println(string);
        }
    }

    private static ArrayList<String> printAllSub(String str) {
        ArrayList<String> list = new ArrayList<>();
        char[] chs = str.toCharArray();
        process(list, chs, 0);
        return list;

    }

    private static void process(ArrayList<String> list, char[] chs, int i) {
        if(i == chs.length){
            list.add(String.valueOf(chs));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int j = i; j < chs.length; j++){
            if(!set.contains(chs[j])){
                set.add(chs[j]);
                swap(chs, i, j);
                process(list, chs, i + 1);
                swap(chs, i, j);
            }
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char help = chs[i];
        chs[i] = chs[j];
        chs[j] = help;
    }
}
