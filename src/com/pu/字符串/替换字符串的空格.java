package com.pu.字符串;

import java.util.Arrays;

/**
 * description：实现一个函数，将字符串p中的所有空格
 *              都替换成为指定的字符串r 和 字符串
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
        String replaceString = replaceStr(str, "%20");
        System.out.println(replaceString);
    }

    private static String replace(String str, char r) {
        /**
         * Description:替换单个字符
         * @auther
         */
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
    private static String replaceStr(String str, String rep){
        /**
         * Description:替换为其他字符串
         * method：1:统计空格数 2：做help数组 3.遍历填入 4：返回字符串
         * @auther
         */
        if(str == null || str.length() == 0
                       ||  rep == null || rep.length() == 0) {
            return null;
        }
        char[] chs = str.toCharArray();
        char[] res = rep.toCharArray();
        int cLen = chs.length;
        int rLen = res.length;
        int spaceNum = 0;
        for(int i = 0; i < cLen; i++){
            if(chs[i] == ' '){
                spaceNum += 1;
            }
        }
        char[] replace = new char[cLen + spaceNum * (rLen - 1)];
        int i = cLen - 1;
        int j = replace.length - 1;
        while(i >= 0 && j >= 0){
            if(chs[i] == ' '){
                for(int k = rLen - 1; k >= 0; k--){
                    replace[j] = res[k];
                    j--;
                }
            }else{
                replace[j] = chs[i];
                j--;
            }
            i--;
        }
        return new String(replace);
    }
}
