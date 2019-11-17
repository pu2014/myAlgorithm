package com.pu.字符串;

import java.util.Arrays;

/**
 * description：实现一个函数，将字符串p中的所有空格
 *              都替换成为指定的字符串r
 *
 * @author Pubojian
 * @date 2019/11/16 20:42
 */
public class 替换字符串的空格 {
    public static void main(String[] args) {
        String str = "ad  bcada";
        char[] chs = str.toCharArray();
        System.out.println(Arrays.toString(chs));
        String res = replace(str, 'r');
        System.out.println(res);
    }

    private static String replace(String str, char r) {
        if(str == null || str.length() == 0){
            return null;
        }
        char[] chs = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            if(chs[i] == ' '){
                chs[i] = r;
            }
        }
        str = new String(chs);
        return str;
    }
}
