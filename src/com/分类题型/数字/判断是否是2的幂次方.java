package com.分类题型.数字;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/14 10:45
 */
public class 判断是否是2的幂次方 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(new IsPowOf2().method(sc.nextInt()));
        }
    }
}
class IsPowOf2{
    public boolean method(int value){
        if(value < 1){
            return false;
        }
        return (value & -value) == value;
    }
}
