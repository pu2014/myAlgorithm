package com.笔试.meituan;

import java.util.*;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/22 16:08
 */
public class MTMian1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        char[] input;
        for(int i = 0; i < n; i++){
            input = sc.nextLine().trim().toCharArray();
            if(input == null || input.length < 2){
                System.out.println("Wrong");
                continue;
            }
            char firstChar = input[0];
            if(!isLittle(firstChar)){
                System.out.println("Wrong");
            }else{
                int k = 1;
                boolean hasNumber = false;
                while(k < input.length){
                    if(isLittle(input[k])){
                        k++;
                    }else if(isNumber(input[k])){
                        k++;
                        hasNumber = true;
                    }else{
                        break;
                    }
                }
                System.out.println((k == input.length && hasNumber) ? "Accept" : "Wrong");
            }
        }
    }
    public static boolean isLittle(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    public static boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
}
