package com.pu.动态规划;

/**
 * @Description: 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: leetcode
 * @Date: Created in 10:08 2019/12/9
 **/
public class 正则表达式匹配 {
    public static void main(String[] args) {
        String s = "aasdfasdfasdfasdfas";
        String p = "aasdf.*asdf.*asdf.*asdf.*s";
        System.out.println(isMatch(s, p));
    }

    private static boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true; //dp[i][j] 表示s的前i个能否被p的前j个匹配
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '*' && dp[0][i - 1]){
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)){//任意元素或者相同元素
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if(p.charAt(j) == '*'){ //如果是*
                    if(p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.'){//前面不匹配
                        dp[i + 1][j + 1] = dp[i + 1][j - 1]; //不匹配直接当作*的个数为0；
                    }else{
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                         /**
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             **/
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
