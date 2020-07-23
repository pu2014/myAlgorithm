package com.笔试.guanglianda;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @DESC 怪物 x  hp
 *          技能  y
 * @CREATE BY @Author pbj on @Date 2020/7/22 11:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            map.put(sc.nextInt(), sc.nextInt());
        }
        

    }
}
