package com.笔试.huaweisx;

import sun.plugin2.gluegen.runtime.CPU;
/*
3 6
10 12 15
8 10
12 11
16 22
13 14
9 11
15 16

3 4
8 12 15
8 56
11 40
14 42
11 44
 */

import java.util.*;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/6 20:01
 */
public class SFMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] serves = new int[n];
        boolean[] isUsed = new boolean[n];
        for(int i = 0; i < n; i++){
            serves[i] = sc.nextInt();
        }
        Arrays.sort(serves);
        List<Node> users = new ArrayList<>();
        for(int i = 0; i < m; i++){
            users.add(new Node(sc.nextInt(), sc.nextInt()));
        }
        users.sort((o1,o2)->{
            if(o1.value != o2.value){
                return o2.value - o1.value;
            }else{
                return o1.cost - o2.cost;
            }
        });

        int idx;
        int noUse = n;
        int count = 0;
        Node cur;

        for(int i = 0; i < users.size() && noUse != 0; i++){
            cur = users.get(i);
            idx = process(serves, isUsed, cur.cost);
            if(idx == serves.length){
                continue;
            }
            isUsed[idx] = true;
            count += cur.cost;
        }
        System.out.println(count);
    }

    private static int process(int[] serves, boolean[] isUsed, int key) {
        int idx = Arrays.binarySearch(serves, key);
        idx = idx < 0 ? - idx - 1 : idx;
        while(idx < serves.length && isUsed[idx] == true){
            idx++;
        }
        return idx;
    }

    static class Node{
        int cost;
        int value;

        public Node(int cost, int value) {
            this.cost = cost;
            this.value = value;
        }
    }
}



