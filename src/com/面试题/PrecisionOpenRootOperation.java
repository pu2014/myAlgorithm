package com.面试题;

/**
 * @DESC   Sqrt
 * @CREATE BY @Author pbj on @Date 2020/5/13 10:21
 */
public class PrecisionOpenRootOperation {
    public static double sqrt(double target, double m){
        double min, max, mid, newMid;
        min = 1;
        max = target;
        mid = min + (max - min)/2;

        do{
            if(mid*mid < target){
                min = mid;
            }else{
                max = mid;
            }
            newMid = mid;
            mid = min + (max - min)/2;
        }while(abs(mid, newMid) > m);
        return mid;
    }

    private static double abs(double a, double b) {
        return a > b ? a - b : b - a;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(20, 0.001));
        System.out.println(Math.sqrt(20));
        System.out.println(sqrt(1, 0.001));
        System.out.println(Math.sqrt(1));
    }
}
