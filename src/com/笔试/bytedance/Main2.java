package com.笔试.bytedance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
5
1 2 +
3 4 -
1000000000 1000000000 *
2 3 ^
2 1000000000 ^
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputTimes = Integer.parseInt(br.readLine().trim());
        int modNum = 1000000007;
        while(inputTimes-- > 0){
            String[] strs = br.readLine().trim().split(" ");
            int a = Integer.parseInt(strs[0]) % modNum;
            int b = Integer.parseInt(strs[1]) % modNum;
            if(strs[2].equals("+")){
                System.out.println((a + b) % modNum);
            }else if(strs[2].equals("-")){
                System.out.println((a - b) % modNum);
            }else if(strs[2].equals("*")){
                System.out.println(a * b % modNum);
            }else{
                System.out.println((int)Math.pow(a, b) % modNum);
            }
        }
    }
}