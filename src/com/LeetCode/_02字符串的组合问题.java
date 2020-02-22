package com.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * description：字符串的组合，数组间元素的组合问题
 * 思想：利用树的发散结构完成（递归 回溯剪枝法）
 * 题目1：电话号码的字母组合
 * -----给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 题目2：字符串的排列
 * -----输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则
 * 打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 题目3：括号生成
 * -----给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 题目4： 二进制手表
 * -----二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * @author Pubojian
 * @date 2020/2/22 11:08
 */
public class _02字符串的组合问题 {
    static List<String> res = new ArrayList<>();
    //建立每个点的对于分钟数
    static int[] hours = {1, 2, 4, 8};
    static int[] mins = {1,2,4,8,16,32};
    public static void main(String[] args) {
        String digits = "23";
        String str = "abc";

        //题目1：电话号码的字母组合
        List<String> letterComStringsList = letterCombinations(digits);
        System.out.println(letterComStringsList.toString());
        //题目2：字符串的排列
        List<String>  permutationList  = permutation(str);
        System.out.println(permutationList.toString());
        //题目3：括号生成
        List<String>  generateParenthesisList  = generateParenthesis(3);
        System.out.println(generateParenthesisList.toString());
        //题目4： 二进制手表
        List<String>  readBinaryWatchList  = readBinaryWatch(2);
        System.out.println(readBinaryWatchList.toString());
    }




    private static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        String[] chs = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        letterCombinationsHelper(digits, 0, new StringBuffer(), chs, res);
        return res;
    }

    private static void letterCombinationsHelper(String digits, int i, StringBuffer sb, String[] chs, List<String> res) {
        if(i == digits.length()){
            res.add(sb.toString());
            return;
        }
        int n = digits.charAt(i) - '0' - 2;
        for(int j = 0; j < chs[n].length(); j++){
            letterCombinationsHelper(digits, i + 1, new StringBuffer(sb).append(chs[n].charAt(j)), chs, res);
        }
    }

    private static List<String> permutation(String str) {
        TreeSet<String> set = new TreeSet<>();
        if(str == null || str.length() == 0){
            return new ArrayList<>();
        }
        permutationHelper(str.toCharArray(), 0, set);
        return new ArrayList<>(set);
    }

    private static void permutationHelper(char[] chs, int i, TreeSet<String> set) {
        if(i == chs.length){
            //System.out.println(chs);
            set.add(String.valueOf(chs));
            return;
        }
        for(int j = i; j < chs.length; j++){
            char temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
            permutationHelper(chs, i + 1, set);
            chs[j] = chs[i];
            chs[i] = temp;

        }

    }

    private static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n < 1){
            return res;
        }
        generateParenthesisHelper(0, 0, res, n, "");
        return res;
    }

    private static void generateParenthesisHelper(int L, int R, List<String> res, int n, String s) {
        if(L == n && R == n){
            res.add(s);
            return;
        }
        if(L < n){
            generateParenthesisHelper(L + 1, R, res, n, s + "(");
        }
        if(R < L){
            generateParenthesisHelper(L, R + 1, res, n, s + ")");
        }
    }

    private static List<String> readBinaryWatch(int num) {
        if(num < 0){
            return res;
        }
        if(num == 0){
            res.add("0:00");
            return res;
        }
        readBinaryWatchHelper(num, 0, new int[10]);
        return res;
    }

    private static void readBinaryWatchHelper(int num, int cur, int[] book) {
        if(num == 0){
            int hourSum = book[0] * 8 + book[1] * 4 + book[2] * 2 + book[3];
            int minuSum = book[4] * 32 + book[5] * 16 + book[6] * 8 + book[7] * 4 + book[8] * 2 + book[9];
            if(hourSum < 12){
                res.add(hourSum + ":" + (minuSum < 10 ? "0" + minuSum : minuSum));
            }
        }
        for(int i = cur; i < book.length; i++){
            book[i] = 1;
            readBinaryWatchHelper(num - 1, i + 1, book);
            book[i] = 0;
        }
    }

    public static  String getTheTime(int hourSum, int minSum){
        return hourSum + ":" + (minSum < 10 ? "0" + minSum : minSum);
    }


}
