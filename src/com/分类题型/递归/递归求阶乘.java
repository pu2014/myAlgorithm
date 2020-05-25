package com.分类题型.递归;

public class 递归求阶乘 {
    public static void main(String[] args){
        int n = 5;
        System.out.println(getFactorial(n));
    }

    private static int getFactorial(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        return n * getFactorial(n-1);
    }
}
