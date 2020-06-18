package com.笔试.IEEE;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/14 9:34
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        int num;
        int res;
        int[] digits = {1, 8, 88, 888, 8888, 88888, 888888, 8888888, 88888888, 888888888};
        while(sc.hasNext()){
            num = sc.nextInt();
            if(num == 0){
                continue;
            }
            res = 0;
            int len = (num + "").length();

            for(int i = len; i < digits.length; i++){
                if(digits[i] % num == 0){
                    res = i;
                    break;
                }
            }
            System.out.println("Case " + count++ + ":" + res);
        }
    }
}
