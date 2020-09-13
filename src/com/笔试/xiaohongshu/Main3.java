package com.笔试.xiaohongshu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/12 11:05
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] length = new int[n];
            int[] width = new int[n];
            int[] height = new int[n];
            for(int i = 0; i < n; i++){
                length[i] = sc.nextInt();
                width[i] = sc.nextInt();
                height[i] = sc.nextInt();
            }
            int res = 0;
            for(int i = 0; i < n; i++){
                res += Math.max(length[i], Math.max(width[i], height[i]));
            }
            System.out.println(res);
        }

    }
    static class Box{

        Integer length;
        Integer width;
        Integer height;

        public Box(Integer length, Integer width, Integer height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }
    }
}

