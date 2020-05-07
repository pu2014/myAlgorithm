package com.分类题型.字符串;

/**
 * @Description:给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * @Author: pubojian
 * @Date: Created in 20:13 2019/11/21
 * @Source:https://www.jianshu.com/p/392172762e55
 **/
public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "lacadafajdjhjkkjhjd";
        String s2 = "babad";
        System.out.println(longestPalindromeV1(s));
        System.out.println(longestPalindromeV2(s));
        System.out.println(longestPalindromeV3(s));
    }

    private static String longestPalindromeV3(String s) {
        /**
         * Description:manacher O(n)
         * @auther
         */
        //最长回文子串的起始索引int index = (i - p[i])/2。
        if(s == null || s.length() == 0){
            return s;
        }
        String str = "#";
        for (int i = 0; i < s.length(); i++) {
            str += s.charAt(i) + "#";
        }
        int[] pArr = new int[str.length()];
        int C = -1;  //前一个当前值
        int R = -1; //最大右边界
        int max = Integer.MIN_VALUE;//最优值
        int maxId = 0;//最优值的坐标
        for (int i = 0; i < str.length(); i++) {
            pArr[i] = R > i ? Math.min(pArr[C * 2 - i], R - i) : 1;
            /** 两种情况：
             * 1：R - i > pArr[j]  i因为 i + j = 2C(对称关系)
             * 2: R - i <= pArr[j]  以j为中心的回文子串超过了以id为中心的回文子串边界，但是由于i和j位置对等，绿框部分还是相同的。所以其向右延伸的范围最大就是mx-i，剩下超过的部分谁也不能保证是否一致，
             * 只能通过循环对比判断，所以p[i] = R - i
             */
            while(i + pArr[i] < str.length() && i - pArr[i] > -1){//防止越界
                if (str.charAt(i + pArr[i]) == str.charAt(i - pArr[i])) {
                    pArr[i]++;
                }else{
                    break;
                }
            }
            if(i + pArr[i] > R){ //更新边界
                R = i + pArr[i];
                C = i;
            }
            if(pArr[i] - 1 > max){
                max = pArr[i] - 1;
                maxId = i;
            }
        }
        int start = (maxId - max) / 2;
        return s.substring(start, start + max);

    }

    private static String longestPalindromeV2(String s) {
        /**
         *@Description：对1进行优化,不使用那么多数组。
         *@Author: pubojian
         *@Date: 2019/11/21 20:30
         **/
        if(s == null || s.length() < 2){
            return s;
        }
        String res = s.substring(0,1);
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length() - 1; j >= i; j--) {
                if (isHuiWen(s, i, j)) {
                    if ((j - i + 1) > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return res;
    }

    private static String longestPalindromeV1(String s) {
        /**
         *@Description：采用类似穷举法
         *@Author: pubojian
         *@Date: 2019/11/21 20:28
         **/
        if(s == null || s.length() < 2){
            return s;
        }
        char[] chs = s.toCharArray();
        int[] arr = {0,0};
        String res = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length() - 1; j >= i; j--){
                if(isHuiWen(chs, i, j)){
                    if((arr[1] - arr[0]) < (j - i)) {
                        arr[0] = i;
                        arr[1] = j;
                    }
                    break;
                }
            }
        }
        for(int i = arr[0]; i <= arr[1]; i++){
            res += chs[i];
        }
        return res;
    }
    private static boolean isHuiWen(char[] chs, int i, int j){
        while(i < j){
            if(chs[i] == chs[j]){
                j--;
                i++;
            }else{
                return false;
            }

        }
        return true;
    }

    private static boolean isHuiWen(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                j--;
                i++;
            }else{
                return false;
            }

        }
        return true;
    }
}
