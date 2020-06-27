package com.分类题型.动态规划.扔鸡蛋;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description:你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 * 示例 1：
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 * 输入：K = 2, N = 6
 * 输出：3
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created By @Author my on @Date 2020/6/23 23:35
 */
public class _887鸡蛋掉落{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(new solution().superEggDrop1(k, n));
        System.out.println(new solution().superEggDrop2(k, n));
        System.out.println(new solution().superEggDrop3(k, n));
    }
    static class solution {
        public int superEggDrop1(int K, int N) {
            return process(K, N);
        }

        private int process(int k, int n) {
            if (k == 1 || n == 0 || n == 1) {
                return n;
            }
            int min = n;
            for (int i = 1; i <= n; i++) {
                int curMin = Math.max(process(k - 1, i - 1), process(k, n - i));
                min = Math.min(curMin + 1, min);
            }
            return min;
        }

        public int superEggDrop2(int K, int N) {
            int[][] dp = new int[K + 1][N + 1];
            //第0层为0.第一层为1
            for (int i = 0; i <= K; i++) {
                dp[i][0] = 0;
                dp[i][1] = 1;
            }
            for (int i = 0; i <= N; i++) {
                dp[0][i] = 0;
                dp[1][i] = i;
            }
            for (int floor = 2; floor <= N; floor++) {
                for (int egg = 2; egg <= K; egg++) {
                    int res = floor;
                    for (int k = 1; k <= floor; k++) {
                        res = Math.min(res, Math.max(dp[egg][floor - k], dp[egg - 1][k - 1]) + 1);
                    }
                    dp[egg][floor] = res;
                }
            }
            return dp[K][N];
        }
        public int superEggDrop3(int K, int N) {
            int C = 1;
            while(calcF(K, C) < N + 1) C++;
            return C;
        }

        private int calcF(int k, int c) {
            if(c == 1 || k == 1){
                return c + 1;
            }
            return calcF(k - 1, c - 1) + calcF(k, c - 1);
        }
    }
}
