package com.分类题型.递归;

public class 递归打印一个字符串的全部子序列 {
    public static void main(String[] args) {
        String str = "abcdefgh";
        printAllSubsquence(str);
    }

    private static void printAllSubsquence(String str) {
        System.out.println("");
        process(str);
    }

    private static void process(String str) {
        for(int i = 1; i < str.length(); i++){
            System.out.println(str.substring(0,i));
        }
        if(str.length() == 0){
            return;
        }
        str = str.substring(1);
        process(str);

    }
}
