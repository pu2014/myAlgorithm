package com.分类题型.动态规划.股票买卖问题;

import com.tools.MyInput;

/**
 * Description:给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created By @Author my on @Date 2020/6/2 9:18
 */
public class _122买卖股票的最佳时机2 {
    public static void main(String[] args) {
        int[] prices = MyInput.inputArray();
        MaxProfit_2 proc = new MaxProfit_2();
        System.out.println(proc.fun(prices));
    }
    static class MaxProfit_2 {
        public int fun(int[] prices) {
            if(prices == null || prices.length < 2){
                return 0;
            }
            int max = 0;
            int inHand = prices[0];
            for(int i = 0; i < prices.length; i++){
                if(prices[i] < inHand){
                    inHand = prices[i];
                }else if(prices[i] > inHand){
                    max += prices[i] - inHand;
                    inHand = prices[i];
                }
            }
            return max;
        }
    }
}
