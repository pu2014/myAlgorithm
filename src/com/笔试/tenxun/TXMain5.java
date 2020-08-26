package com.笔试.tenxun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/23 20:46
 */
public class TXMain5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0){
            String[] s = br.readLine().split(" ");
            int l = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            String cur = str.substring(l - 1, r);
            System.out.println(cur);
            System.out.println(process(cur));
        }

    }

    private static boolean check(char[] chs, int i, int j){
        for(int pos = i; pos <= (i + j) / 2; pos++){
            if(chs[pos] != chs[j + i - pos]){
                return false;
            }
        }
        return true;
    }

    private static int process(String cur) {
        char[] chs = cur.toCharArray();
        int n = chs.length - 1;
        if(check(chs, 0, n)){
            return 1;
        }
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n ; i++){
            dp[i] = i + 1;
        }
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= i; j++){
                if(check(chs, j, i)){
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n];

    }
}
