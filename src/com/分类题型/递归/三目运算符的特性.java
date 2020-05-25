package com.分类题型.递归;

/**
 * 三目运算符中++ ——的特性
 * 只有被选择的才会继续运算
 */
public class 三目运算符的特性 {
    public static void main(String[] args) {
        int a = 1,b = 5;
        System.out.println(a > b ? a++:b++);
        System.out.println(a);
        System.out.println(b);
    }
}
