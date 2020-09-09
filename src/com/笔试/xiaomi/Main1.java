package com.笔试.xiaomi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/8 18:50
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < 8 || strs[i].length() > 120){
                System.out.println(1);
            }else{
                boolean isNumber = false;
                boolean isBigChar = false;
                boolean isSmallChar = false;
                boolean isFuHao = false;
                for(int k = 0; k < strs[i].length(); k++){
                    if(strs[i].charAt(k) >= '0' && strs[i].charAt(k) <= '9'){
                        isNumber = true;
                    }else if(strs[i].charAt(k) >= 'A' && strs[i].charAt(k) <= 'Z'){
                        isBigChar = true;
                    }else if(strs[i].charAt(k) >= 'a' && strs[i].charAt(k) <= 'z'){
                        isSmallChar = true;
                    }else{
                        isFuHao = true;
                    }
                }
                System.out.println(isBigChar && isNumber && isSmallChar && isFuHao ? 0 : 2);
            }
        }
    }
}
