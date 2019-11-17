package com.pu.字符串;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * description：在字符串中找出第一个只出现一次的字符。如输入adaccbeff，
 *                则输出b，要求时间复杂度为O(n)。
 *
 * @author Pubojian
 * @date 2019/11/17 14:54
 */
public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        String str = "adaccbeff";
        char res1 = firstNotRepeat1(str);
        System.out.println(res1);
        char res2 = firstNotRepeat2(str);
        System.out.println(res2);
    }

    private static char firstNotRepeat1(String str) {
        /**
         * Description:利用数组(顺序有问题，只有有序数组可以)
         * @auther pubojian
         */
        if(str == null || str.length() == 0){
            return '\u0000';
        }
        char[] chs = str.toCharArray();
        int len = chs.length;
        int[] help = new int[256];
        for(int i = 0; i < len ; i++){
            help[chs[i]] += 1;
        }
        for(int i = 0; i < help.length; i++){
            if(help[i] == 1){
                return (char)i;
            }
        }
        return '\u0000';

    }

    private static char firstNotRepeat2(String str) {
        /**
         * Description:利用LinkedMap实现，不改变位置
         * @auther pubojian
         */
        if(str == null || str.length() == 0){
            return '\u0000';
        }
        Map<Character,Integer> map = new LinkedHashMap<>();
        char[] chs = str.toCharArray();
        int len = chs.length;
        for(int i = 0; i < len; i++){
            if(!map.containsKey(chs[i])){
                map.put(chs[i],1);
            }else{
                map.put(chs[i],map.get(chs[i]) + 1);
            }
        }
        for(char ch : map.keySet()){
            if(map.get(ch) == 1){
                return ch;
            }
        }
        return '\u0000';

    }
}
