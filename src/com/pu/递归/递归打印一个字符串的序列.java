package com.pu.递归;

public class 递归打印一个字符串的序列 {
    public static void main(String[] args) {
        String test = "ab";
        printAllSub(test,0,"");
    }

    private static void printAllSub(String str, int i , String res){
        if(i == str.length()){
            System.out.println(res);
            return;
        }
        printAllSub(str,i + 1,res);
        printAllSub(str,i + 1,res + str.charAt(i));

    }
}
