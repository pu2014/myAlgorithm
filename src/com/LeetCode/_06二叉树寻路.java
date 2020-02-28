package com.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * description：
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。

 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，
 * 该路径是由途经的节点标号所组成的。
 * 示例 1：
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：

 * 输入：label = 26
 * 输出：[1,2,6,10,26]*
 * @author Pubojian
 * @date 2020/2/26 20:35
 */
public class _06二叉树寻路 {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> list = s.pathInZigZagTree(26);
        System.out.println(list.toString());
    }
}
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int n = 1;
        while(label >= (1 << n)){
            n++;
        }
        TreeSet<Integer> set = new TreeSet<>();

        if(n % 2 == 0){
            set.add(label);
            label = (1 << (n - 1)) + (1 << n) - 1 - label;
            label = (label >> 1);
            n--;
        }

        while(n > 0){
            if(n % 2 == 0){
                label = (1 << (n - 1)) + (1 << n) - 1 - label;
            }
            set.add(label);
            label = label / 2;
            n--;
        }
        return new ArrayList<>(set);
    }
}


