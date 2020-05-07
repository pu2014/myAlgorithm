package com.分类题型.位操作运算;

/**
 * description：求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * @author Pubojian
 * @date 2020/2/1 17:43
 */
public class 与运算的短路原理代替判断 {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(sum(n));
    }

    private static int sum(int n) {
        int sum = n;
        //作为递归的判断条件，不能用if 用&&短路原理
        boolean flag = (n > 0) && (sum += sum(n - 1)) > 0;
        return sum;
    }
}
