package com.笔试.IEEE;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/14 15:31
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>(N);
        for(int i = 0; i < N; i++){
            List<Integer> list = new ArrayList<>();
            while(true){
                int num = sc.nextInt();
                if(num == 0){
                    break;
                }
                list.add(num);
            }
            map.put(i + 1, list);
        }
        System.out.println(map);
        int[][] dp = new int[N + 1][2];

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(map.get())
        }
    }
    static class Node{
        int ll;
        int rr;

        public Node(int ll, int rr) {
            this.ll = ll;
            this.rr = rr;
        }
    }
}
