package com.pu.数字;

import java.util.ArrayList;
/**
 * description：链接：https://www.nowcoder.com/questionTerminal/11c9f023a9f84418a15b48792a5f7c70
 * 来源：牛客网
 *
 * 春天是鲜花的季节，水仙花就是其中最迷人的代表，
 * 数学上有个水仙花数，他是这样定义的：“水仙花数”是指一个三位数，
 * 它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。
 * 现在要求输出所有在m和n范围内的水仙花数
 *
 * @author Pubojian
 * @date 2020/2/13 22:17
 */
public class 水花仙数 {
    public static boolean isFlower(int i){
        int res = 0;
        int n = i;
        while(n > 0){
            res += Math.pow(n % 10, 3);
            n = n / 10;
        }
        if(i == res) return true;
        else return false;
    }

    public static void main(String[] args) {
        getTheFlowers(0, 999);
    }
    public static void getTheFlowers(int m, int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = m; i <= n; i++){
        if(isFlower(i)){
            list.add(i);
        }
    }
        if(list.isEmpty()){
        System.out.println("no");
        }else{
            for(int i = 0; i < list.size() - 1; i++){
                System.out.print(list.get(i) + " ");
            }
        System.out.println(list.get(list.size() - 1));
        }
    }
}
