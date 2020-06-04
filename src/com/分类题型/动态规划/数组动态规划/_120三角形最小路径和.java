package com.分类题型.动态规划.数组动态规划;

/**
 * Description:
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created By @Author my on @Date 2020/6/3 11:59
 */
public class _120三角形最小路径和 {
    public static void main(String[] args) {
        int[][] triangle = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        MinimumTotal proc = new MinimumTotal();
        System.out.println(proc.minimumTotal(triangle));
    }
}
class MinimumTotal {
    public int minimumTotal(int[][] triangle) {
        int[] dp = new int[triangle.length + 1];
        for(int i = triangle.length - 1; i >= 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        return dp[0];
    }
}
