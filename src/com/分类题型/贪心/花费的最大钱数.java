package com.分类题型.贪心;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入1：正数数组costs  项目i的花费
 * 输入2：正数数组profits  项目i的利润（扣除花费的）
 * 输入3：正数k      k表示你不能并行、只能串行的最多做k个项目
 * 输入4：正数m      m表示初始资金
 *
 * 说明 ：你每做完一个项目，马上获得的资金可以支持你去做下一个项目
 * 输出：你最后获得的最大钱数
 *
 *
 * 堆结构实现
 * 贪心问题
 */
public class 花费的最大钱数 {
    public static void main(String[] args) {
        int [] costs = {1,2,3,4,5,6};
        int [] profits = {2,2,4,3,5,7};
        int k = 4;
        int c = 2;
        System.out.println(findMaximizedCapital(costs,profits,k,c));
    }

    private static int findMaximizedCapital(int[] costs, int[] profits, int k, int c) {
        Node []project = new Node[costs.length];
        for(int i = 0;i < costs.length;i++){
            project[i] = new Node(costs[i],profits[i]);
        }
        PriorityQueue<Node> minCostHeap = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitHeap = new PriorityQueue<>(new MaxProfitComparator());
        for(int i = 0;i < costs.length;i++){
            minCostHeap.add(project[i]);
        }
        for(int i = 0;i < k;i++){
            while(!minCostHeap.isEmpty() && minCostHeap.peek().cost <= c){
                maxProfitHeap.add(minCostHeap.poll());
            }
            if(maxProfitHeap.isEmpty()){
                return c;
            }
            c += maxProfitHeap.poll().profit;
        }
        return c;
    }

    public static class Node{
        public int cost;
        public int profit;

        public Node(int c, int p) {
            this.cost = c;
            this.profit = p;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

}
