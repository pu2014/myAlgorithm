package com.笔试.tenxun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/23 20:05
 */
public class TXMain1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String[] nums = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(i != k - 1){
                sb.append(nums[i]).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
