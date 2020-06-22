package com.分类题型.栈列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @DESC
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 * 示例 1：
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/6/22 16:40
 */
public class _862和至少为K的最短子数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        ShortestSubarray proc = new ShortestSubarray();
        System.out.println(proc.fun1(nums, k));
        System.out.println(proc.fun2(nums, k));
    }
}
class ShortestSubarray {
    /**
     * 前缀和暴力 n^2
     * @param A
     * @param K
     * @return
     */
    public int fun1(int[] A, int K) {
        int minLen = A.length + 1;
        int[] preSum = new int[A.length + 1];
        for(int i = 0; i < A.length; i++){
            preSum[i + 1] = preSum[i] + A[i];
        }
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length + 1; j++){
                if(preSum[j] - preSum[i] >= K){
                    minLen = Math.min(j - i, minLen);
                }
            }
        }
        return minLen == A.length + 1 ? -1 : minLen;
    }
    public int fun2(int[] A, int K) {
        int minLen = A.length + 1;
        int[] preSum = new int[A.length + 1];
        for(int i = 0; i < A.length; i++){
            preSum[i + 1] = preSum[i] + A[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < A.length + 1; i++){
            //x[a] < x[b] a > b 时， 肯定取 b- a 为负数， 取a后面的
            while(!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]){
                deque.pollLast();
            }
            while(!deque.isEmpty() && preSum[i] - preSum[deque.peekFirst()] >= K){
                int curLen = i - deque.pollFirst();
                minLen = Math.min(curLen, minLen);
            }
            deque.addLast(i);
        }
        return minLen == A.length + 1 ? -1 : minLen;
    }

}