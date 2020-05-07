package com.分类题型.数组;

public class 无空间交换数据 {
        public static void main(String[]args){
            int a = 55;
            int b = 66;
            swap1(a,b);
            swap2(a,b);
            swap3(a,b);
            System.out.println("a="+a);
            System.out.println("b="+b);
        }

    private static void swap3(int a, int b) {
            //注意相同下角标的问题
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;

    }

    private static void swap1(int a, int b) {
            int temp;
            temp = a;
            a = b;
            a = temp;
    }
    private static void swap2(int a,int b){
            a = a + b;
            b = a - b;
            a = a - b;

    }

}
