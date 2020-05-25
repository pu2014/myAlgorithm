package com.剑指Offer;

import com.tools.Print;

import java.util.Scanner;

/**
 * @DESC 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @CREATE BY @Author pbj on @Date 2020/5/20 14:24
 */
public class _43求1到n的等差和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sum_Solution proc = new Sum_Solution();
        while(sc.hasNext()){
            int n = sc.nextInt();
            Print.out(proc.fun(n));
        }
    }

}
class Sum_Solution {
    public int fun(int n) {
        boolean flag = n > 0 && (n = n + fun(n - 1)) > 0;
        return n;
    }
}
