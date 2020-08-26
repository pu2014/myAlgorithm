package com.笔试.tenxun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/23 20:19
 */
public class TXMain2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        if(str == ""){
            System.out.println("");
            return;
        }
        int k = Integer.parseInt(br.readLine());
        int cnt = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            for(int j = i + 1; j <= str.length(); j++){
                String cur = str.substring(i, j);
                if(!set.contains(cur)) {
                    cnt++;
                    set.add(cur);
                    if (cnt == k) {
                        System.out.println(str.substring(i, j));
                    }
                }
            }
        }
    }
}
