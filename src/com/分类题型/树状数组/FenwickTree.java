package com.分类题型.树状数组;

/**
 * description：数组-->树状数组-->前缀和
 *
 *
 * @author Pubojian
 * @date 2020/3/8 17:11
 */
public class FenwickTree {
    private int[] tree;
    private int len;

    public FenwickTree(int n){
        this.len = n;
        tree = new int[n + 1];
    }
    public int query(int i) {
        // 从右到左查询
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }

    public static int lowbit(int x) {
        return x & (-x);
    }
}

