package com.笔试.meituan;

import java.util.*;

public class MTMain3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer, Integer> res = new LinkedHashMap();
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i = 0; i < n ; i++){
            int sum = sc.nextInt() + 2 * sc.nextInt();
            if(min.size() < m){
                min.add(sum);
                res.put(sum, i + 1);
            }else{
                Integer cur = min.peek();
                if(sum > cur){
                    res.remove(cur);
                    min.poll();
                    min.add(sum);
                    res.put(sum, i + 1);
                }
            }
        }
        for(int i : res.values()){
            System.out.println(i + " ");
        }
    }
}
/*
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] num = new int[n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                num[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> list = find(num, n, m);
        for(int i : list){
            System.out.println(i + " ");
        }
    }
    public static ArrayList find(int[][] arr, int n, int m){
        ArrayList<Integer> list = new ArrayList<>();
        if(arr == null || arr.length < m){
            return list;
        }
        PriorityQueue<Integer> min = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n ; i++){
            int sum = arr[i][0] + 2 * arr[i][1];
            if(min.size() < m){
                min.add(sum);
                list.add(i + 1);
                map.put(sum, i + 1);
            }else{
                Integer cur = min.peek();
                if(sum > cur){
                    list.remove(map.get(cur));
                    min.poll();
                    min.add(sum);
                    list.add(i + 1);
                }
            }
        }
        return list;
    }
 */
