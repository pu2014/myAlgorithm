package com.剑指Offer;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Description:
 *      输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由
 *      字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * Created By @Author my on @Date 2020/4/20 21:03
 */
public class _26字符串的排列 {
    public static void main(String[] args) {
        String str = "ABC";
        System.out.println(new Permutation().method(str));
    }
}
class Permutation {
    public ArrayList<String> method(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        TreeSet<String> set = new TreeSet<>();
        methodHelper(0, str.toCharArray(), set);
        return new ArrayList<>(set);
    }

    private void methodHelper(int cnt, char[] chs, TreeSet<String> res) {
        if(cnt == chs.length){
            res.add(String.valueOf(chs));
            return;
        }
        for(int i = cnt; i < chs.length; i++){
            char tmp = chs[i]; //交换
            chs[i] = chs[cnt];
            chs[cnt] = tmp;

            methodHelper(cnt + 1, chs, res);

            chs[cnt] = chs[i];  // 交换回来
            chs[i] = tmp;
        }
    }

}

