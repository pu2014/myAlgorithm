package com.分类题型.数字;

/**
 * description：给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整
 * 数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，
 * 我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *  输入一个数n，输出最大乘积。（2 <= n <= 60）
 * @author Pubojian
 * @date 2020/2/1 13:29
 */
public class 剪绳子 {
    public static void main(String[] args) {
        int target = 10;
        System.out.println(cutRopeV1(target));
        System.out.println(cutRopeV2(target));
        int target1 = 9;
        System.out.println(cutRopeV1(target1));
        System.out.println(cutRopeV2(target1));


    }

    private static int cutRopeV2(int target) {
        System.out.print("cutRopeV2————>动态规划：");
        if(target < 2 || target > 60){
            return -1;
        }
        if(target < 4){
            return target - 1;
        }
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= target; i++) {
            for (int j = 2; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[target];
    }

    private static int cutRopeV1(int target) {
        System.out.print("cutRopeV1————>贪心递归：");
        if(target < 2 || target > 60){
            return -1;
        }
        //2 3 特别处理
        if(target < 4){
            return target - 1;
        }
        return cutRopeMax(target);

    }

    private static int cutRopeMax(int target) {
        //递归部分 最小单元为2 3 4 ，最靠近3为每一段（观察归纳）。
        if(target < 5){
            return target;
        }else{
            return 3 * cutRopeMax(target - 3);
        }
    }
}
