package com.剑指Offer;

import com.tools.Print;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/20 14:26
 */
public class _44不用加减乘除做加法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TwoNumsAdd proc = new TwoNumsAdd();
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(proc.add(n, m));
        }
    }
}
class TwoNumsAdd {
    public int add(int num1,int num2) {
        int p, q;
        do{
            p = num1 ^ num2;
            q = (num1 & num2) << 1;
            num1 = p;
            num2 = q;
        }while(q != 0);
        return p;
    }
}
