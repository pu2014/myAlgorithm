package com.分类题型.动态规划.股票买卖问题;

import com.tools.MyInput;

/**
 * Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created By @Author my on @Date 2020/6/1 12:08
 */
public class _121买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = MyInput.inputArray();
        MaxProfit_1 proc = new MaxProfit_1();
        System.out.println(proc.fun(prices));
    }
    private static class MaxProfit_1 {
        public int fun(int[] prices) {
            if(prices == null || prices.length < 2){
                return 0;
            }
            int in_hand = prices[0];
            int max = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] < in_hand){
                    in_hand = prices[i];
                }else if(prices[i] - in_hand > max){
                    max = prices[i] - in_hand;
                }
            }
            return max;
        }
    }
}


