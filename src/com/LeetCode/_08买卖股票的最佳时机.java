package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * description：如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润
 * 注意你不能在买入股票前卖出股票。
 *  121. 买卖股票的最佳时机
 *      输入: [7,1,5,3,6,4]
 *      输出: 5
 *      解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *  122. 买卖股票的最佳时机 II
 *      输入: [7,1,5,3,6,4]
 *      输出: 7
 *      解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * @author Pubojian
 * @date 2020/3/9 12:07
 */
public class _08买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        MaxProfit fun = new MaxProfit();
        System.out.println("maxProfit_121 " + fun.maxProfit_121(nums));
        System.out.println("maxProfit_122_1 " + fun.maxProfit_122_1(nums));
        System.out.println("maxProfit_122_2 " + fun.maxProfit_122_2(nums));
    }
}
class MaxProfit {
    /**
     * 计算每一天可以获得的最大值，即当天的价格 - 当天之前的最低价格
     * @param prices
     * @return
     */
    public int maxProfit_121(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int max = 0;
        int low = 0;
        /**
         //O(n^2)
         for(int i = 0; i < prices.length; i++){
         for(int j = i + 1; j < prices.length; j++){
         max = Math.max(max, prices[j] - prices[i]);
         }
         }
         return max;
         **/
        //o(n)
        for(int i = 1; i < prices.length; i++){
            max = Math.max(prices[i] - prices[low], max);
            low = prices[i] < prices[low] ? i : low;
        }
        return max;
    }

    /**
     * 找波峰 波谷
     * @param prices
     * @return
     */
    public int maxProfit_122_1(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int valley = prices[0]; //波谷
        int peak = prices[0]; //波峰
        int maxProfit = 0; //最大利润
        int i = 0;
        int len = prices.length;
        while(i < len){
            //找波谷
            while(i < len - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            valley = prices[i];
            //找波峰
            while(i < len - 1 && prices[i] <= prices[i + 1]){
                i++;
            }
            peak = prices[i];
            maxProfit += peak - valley;
            i++;
        }
        return maxProfit;
    }

    /**
     * 如果在涨，每天记录利润，即
     * 135134  波峰波谷计算就是 1 - 5  1 - 4  = 7
     *         每天记录就是  1 - 3 = 2  5 - 3 = 2
     *          3 - 1 = 2 4 - 3 = 1
     *
     * @param prices
     * @return
     */
    public int maxProfit_122_2(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int maxProfit = 0; //最大利润
        for(int i = 1; i < prices.length; i++){
            maxProfit += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return maxProfit;
    }
}