package com.pu.字符串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * description：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则输出由
 * 字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 *
 * @author Pubojian
 * @date 2019/11/17 12:39
 */
public class 打印字符串的所有排列 {
    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> list;
        list = printAllSub(str);
        for(String string : list){
            System.out.println(string);
        }
    }

    private static ArrayList<String> printAllSub(String str) {
        TreeSet<String> set = new TreeSet<>();
        char[] chs = str.toCharArray();
        process(set, chs, 0);
        return new ArrayList<>(set);

    }

    private static void process(TreeSet<String> set, char[] chs, int i) {
        if(i == chs.length){
            set.add(String.valueOf(chs));
            return;
        }
        for(int j = i; j < chs.length; j++){
                swap(chs, i, j);
                process(set, chs, i + 1);
                swap(chs, i, j);
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char help = chs[i];
        chs[i] = chs[j];
        chs[j] = help;
    }
}
