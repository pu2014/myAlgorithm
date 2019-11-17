package com.pu.树;


//类似折叠打印
public class 纸的折叠打印 {
    public static void main(String[] args){
        int N = 3;
        printAllFolds(N);
    }

    public static void printAllFolds(int N){
        printProcess(1,N,true);
    }

    private static void printProcess(int i, int n, boolean down) {
        if(i > n){
            return;
        }
        printProcess(i + 1,n,true); // down likes left
        System.out.println(down ? "down" : "up");
        printProcess(i + 1,n,false);
    }
}
