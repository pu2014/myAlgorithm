package com.剑指Offer;

import java.util.Scanner;

/**
 * @DESC  在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * @CREATE BY @Author pbj on @Date 2020/5/18 19:24
 */
public class _33第一个只出现一次的字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(new FirstNotRepeatingChar().fun(str) );
    }
}
class FirstNotRepeatingChar {
    public int fun(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        int[] chs = new int[58];
        int[] inx = new int[58];
        int index = 0;
        for(int i = 0; i < str.length(); i++){
            index = str.charAt(i) - 'A';
            chs[index]++;
            if(chs[index] == 1){
                inx[index] = i;
            }
        }
        index = 59;
        for(int i = 0; i < 58; i++){
            if(chs[i] == 1 && inx[i] < index){
                index = inx[i];
            }
        }
        return index == 59 ? -1 : index;
    }
}