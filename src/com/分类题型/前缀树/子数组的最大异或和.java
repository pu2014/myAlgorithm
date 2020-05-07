package com.分类题型.前缀树;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/17 23:08
 */
public class 子数组的最大异或和 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(getMaxEOR1(arr));
        System.out.println(getMaxEOR2(arr));
        System.out.println(getMaxEOR3(arr));
    }


    private static int getMaxEOR1(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int eor = 0;
            for(int j = i; j < arr.length; j++){
                eor ^= arr[j];
                max = Math.max(max, eor);
            }
        }
        return max;
    }

    public static int getMaxEOR2(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[arr.length];
        int eor = 0;
        for(int i = 0; i < arr.length; i++){
            eor ^= arr[i];
            max = Math.max(max, eor);
            for(int start = 1; start <= i; start++){
                int cur = eor ^ dp[start - 1];
                max = Math.max(max, cur);
            }
            dp[i] = eor;
        }
        return max;
    }
    public static class Node{
        public Node[] nexts = new Node[2];
    }
    public static class NumTrie{
        public Node head = new Node();

        public void add(int num){
            Node cur = head;//int一共31
            for(int move = 31; move >= 0; move--){
                int path = (( num >> move) & 1); //当前位数，将int的32位的每一位都分离出来
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];//如果下一节点存在就不动，否则添加一个结点
                cur = cur.nexts[path];
            }
        }
        public int maxXor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                int best = move == 31 ? path : (path ^ 1);
                best = cur.nexts[best] != null ? best : (best ^ 1);
                res |= (path ^ best) << move;
                cur = cur.nexts[best];
            }
            return res;
        }

    }


    private static int getMaxEOR3(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int eor = 0;
        NumTrie numTrie = new NumTrie();
        numTrie.add(0);
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            max = Math.max(max, numTrie.maxXor(eor));
            numTrie.add(eor);
        }
        return max;
    }

}

