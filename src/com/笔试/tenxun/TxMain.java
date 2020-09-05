package com.笔试.tenxun;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/27 19:14
 */
public class TxMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(process(str1, str2));
        }
    }

    /**
     *
     * @param str1  原字符串
     * @param str2  匹配字符串
     * @return
     */
    private static boolean process(String str1, String str2) {
        if((str1 == null && str2 == null) || (str1.length() == 0 && str2.length() == 0)){
            return true;
        }
        boolean[][] dp = new boolean[str1.length() + 1][str2.length() + 1];
        dp[0][0] = true;
        /**
         *       a b c        a b b b c
         *                  T F F F F F
         *       0  *     a F T F F F
         *                b F F T F F
         *                * F T T T
         *                c F F F F
         */
        for(int i = 0; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j) || str2.charAt(j) == '0'){
                    dp[i + 1][j + 1] = dp[i][j];
                }else if(str2.charAt(j) == '*' && j > 0 && i > 0){
                    dp[i + 1][j + 1] = dp[i][j] || dp[i][j - 1] || dp[i + 1][j];
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
