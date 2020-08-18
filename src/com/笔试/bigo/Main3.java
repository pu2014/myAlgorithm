package com.笔试.bigo;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/18 20:28
 */
public class Main3 {
    public static Character getSecindChar(String param){
        int[] chsCount = new int[26];
        for(char c : param.toCharArray()){
            chsCount[c - 'a']++;
        }
        int cnt = 0;
        for(char c : param.toCharArray()){
            if(chsCount[c - 'a'] == 4){
                cnt++;
            }
            if(cnt == 2){
                return c;
            }
        }
        return null;
    }
}
