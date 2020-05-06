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
public class HWSXMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] cpu = new int[M];
        for(int i = 0; i < M; i++){
            cpu[i] = sc.nextInt();
        }
        Arrays.sort(cpu);
        TreeSet<CPUNode> set = new TreeSet<>((o1, o2)->{
            if(o1.free != o2.free){
                return o1.free - o2.free;
            }else{
                return o2.value - o1.value;
            }
        });
        for(int i = 0; i < N; i++){
            int free = sc.nextInt();
            int cost = sc.nextInt();
            set.add(new CPUNode(free, cost));
        }

        ArrayList<Integer> res = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < M; i++){
            int[] max = new int[2];
            int lim = cpu[i];
            for(CPUNode key : set){
                if(key.free <= lim){
                    if(key.value > max[1] && !res.contains(key.free + key.value)){
                        max[0] = key.free;
                        max[1] = key.value;
                    }
                }
                if(key.free > lim){
                    break;
                }
            }
            res.add(max[0] + max[1]);
            sum += max[1];
        }
        System.out.println(sum);
    }
}
class CPUNode{
    int free;
    int value;

    public CPUNode(int free, int value) {
        this.free = free;
        this.value = value;
    }
}


