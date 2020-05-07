package com.分类题型.递归;

public class 递归汉诺塔 {
    public static void main(String[] args){
        int n = 3;
        hanoi(n);
    }

    private static void hanoi(int n) {
        if(n > 0){
            func(n,"left","mid","right");
        }
    }

    private static void func(int rest, String from, String help, String to) {
        if(rest == 1){
            System.out.println("move " + rest + " from " + from + " to " + to);
        }else{
            func( rest - 1 , from, to , help);
            System.out.println("move " + rest + " from " + from + " to " + to);
            func(rest - 1, help, from, to);
        }
    }

}
