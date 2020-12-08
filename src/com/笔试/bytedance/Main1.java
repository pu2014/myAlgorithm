package com.笔试.bytedance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @DESC  最短循环子串
 * @CREATE BY @Author pbj on @Date 2020/9/20 19:19
 */
public class Main1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        char[] chs = str.toCharArray();
        int len = chs.length;
        int[] next = new int[len];
        int i = 0, j = 0;
        next[i] = j;
        for(i = 1; i < len; i++){
            while(j > 0 && chs[i] != chs[j]){
                j = next[j - 1];
            }
            if(chs[i] == chs[j]){
                j++;
            }
            next[i] = j;
        }
        int L = len - next[len - 1];
        System.out.println((len % L == 0) ? str.substring(0,L) : str);
    }

    /**
     * @DESC
     * @CREATE BY @Author pbj on @Date 2020/9/20 19:36
     */
}
