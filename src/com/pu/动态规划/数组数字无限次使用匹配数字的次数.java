package com.pu.动态规划;

import java.util.Date;

/**
 * @Description:给定数组arr，arr中所有的值都为正数且不重复，
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，在给定一个整数
 * aim代表要找的钱数，求换钱还有多少种方法。
 *
 * 动态规划：
 *  1：本质是利用申请的空间记录记录每一个暴力搜索的计算结果，下次要用结果的
 *  时候直接使用，而不再进行重复的递归过程。
 *  2：动态规划规定每一种递归状态的计算顺序，一次进行计算。
 *
 *  1：暴力搜索。
 *  2：在暴力搜索方法函数中哪些参数可以代替递归过程。
 *  3：找到代表递归过程的参数实现记忆化搜索
 *  4：通过分析记忆化搜索改出动态规划方法。
 * @Author: pubojian
 * @Date: Created in 11:01 2019/12/3
 **/
public class 数组数字无限次使用匹配数字的次数 {
    public static void main(String[] args){
        int[] arr = {5, 10 ,25, 1};
        int aim = 1000;
        System.out.println("暴力搜索：" + coins1(arr, aim));
        System.out.println("记忆搜索：" + coins2(arr, aim));
        System.out.println("递归搜索：" + coins3(arr, aim));

    }

    private static int coins3(int[] arr, int aim) {
        /**
         *@Description递归运算
         *  行数代表 aim数 列数代表钱数 dp[][]代表方法数
         *    0 1 2 3 ...aim
         *  0
         *  1
         *  2
         *  3
         *  .
         *  N
         *@Author: pu
         *@Date: 2019/12/3 13:23
         **/
        if(arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        //初始化第一行矩阵
        for(int j = 0; j < aim + 1; j++){
            if(j % arr[0] == 0){
                dp[0][j] = 1;
            }
        }
        //初始第一列矩阵
        for(int i = 0; i < arr.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < arr.length; i++){
            for (int j = 1; j < aim + 1; j++) {
                for(int k = 0; k * arr[i] <= j; k++){
                    dp[i][j] += dp[i - 1][j - k * arr[i]];
                }
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static int coins1(int[] arr, int aim){
        /**
         *@Description：暴力搜索法
         *@Author: pu
         *@Date: 2019/12/3 11:06
         **/
        if(arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        return process1(arr, 0 , aim);
    }

    private static int process1(int[] arr, int index, int aim) {
        //递归函数
        int res = 0;
        if(index == arr.length){
            res = aim == 0 ? 1 : 0;
        }else{
            for(int i = 0; arr[index] * i <= aim; i++){
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static int coins2(int[] arr, int aim){
        /**
         *@Description：记忆搜索方法
         *@Author: pu
         *@Date: 2019/12/3 11:15
         **/
        if(arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    private static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if(index == arr.length){
            res = aim == 0 ? 1 : 0;
        }else{
            int mapValue = 0;
            for(int i = 0; arr[index] * i <= aim; i++){
                mapValue = map[index + 1][aim - arr[index] * i];
                if(mapValue != 0){
                    res += mapValue == -1 ? 0 : mapValue;
                }else{
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }
}
