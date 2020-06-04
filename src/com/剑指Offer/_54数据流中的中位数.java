package com.剑指Offer;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/22 17:42
 */
public class _54数据流中的中位数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GetMedium proc = new GetMedium();
        while(sc.hasNext()){
            int n = sc.nextInt();
            proc.insert(n);
            System.out.println(proc.getMid());
        }
    }
}
class GetMedium {
    /**
     * 大根堆
     */
    PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2)->o2-o1);
    /**
     * 小根堆
     */
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public void insert(Integer num) {
        if(right.isEmpty()){
            right.add(num);
        }else{
            if(num >= right.peek()){
                right.add(num);
            }else{
                left.add(num);
            }
            while(right.size() - 1 > left.size()){
                left.add(right.poll());
            }
            while(left.size() > right.size()) {
                right.add(left.poll());
            }
        }
    }

    public Integer getMid() {
        return left.size() == right.size() ? (left.peek() >> 1) + (right.peek() >> 1) : right.peek();
    }
}