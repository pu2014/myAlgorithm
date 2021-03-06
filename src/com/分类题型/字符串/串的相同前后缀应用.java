package com.分类题型.字符串;

/**
 * description：串的相同前后缀是指的是串包含不含首元素的串长度
 * 与不含尾元素的串的长度一致的最大长度
 * 例如 ababc  在c前为2
 * next 数组为[-1, 0 , 0, 1, 2]
 * 案例一：求KMP问题见字符串/KMP问题...
 * 案例二：京东面试题：在字符串后添加“最短的”前面出现的字符串子串使其
 * 包换两个原始字符串。
 *
 * @author Pubojian
 * @date 2020/1/31 22:33
 */
public class 串的相同前后缀应用 {
    public static void main(String[] args) {
        String str = "aaaaa";
        //得到最大的前后缀
        int index = getMaxIndex(str);
        System.out.println(index);
        System.out.println(str + str.substring(0,str.length() - index));

        String str1 = "abcabc";
        //得到最大的前后缀
        int index1 = getMaxIndex(str1);
        System.out.println(index1);
        System.out.println(str1 + str1.substring(0,str1.length() - index1));

    }

    private static int getMaxIndex(String str) {
        if(str.length() < 1){
            return -1;
        }
        int[] next = new int[str.length()];
        int max = 0;
        next[0] = 0;
        int i = 1;
        int cn = 0;
        while(i < next.length){
            if(str.charAt(i) == str.charAt(cn)){
                next[i++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        for(int ns : next){
            if(max < ns){
                max = ns;
            }
        }
        return max;
    }
}
