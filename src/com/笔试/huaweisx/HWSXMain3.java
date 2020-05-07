package com.笔试.huaweisx;

import com.tools.Tree;
import com.tools.TreeNode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @DESC 二叉树的最大路段价值（单节点/和多节点）
 * input: -1(3,2)
 * output:3
 *
 * -1(3,2(0,-1)) 0代表null节点
 * @CREATE BY @Author pbj on @Date 2020/5/6 20:10
 */
public class HWSXMain3 {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getMaxRoad(str));
    }

    private static TreeNode createTreeNode(String str){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        TreeNode p = null;

        int k, j = 0;
        int num = 0;
        int flag = 1;
        while(j < str.length()){
            char ch = str.charAt(j);
            if(ch == '-'){
                flag = -1;
                j++;
            }else if(ch - '0' >= 0 && ch - '0' <= 9){
                num = num + 10 + (ch - '0');
                j++;
                if(j < str.length());
            }

        }
        return null;
    }
    //-1(3,2)
    private static int getMaxRoad(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        int i = 0;
        while(i < str.length()){
            if(str.charAt(i) == '('){
                break;
            }
            i++;
        }
        int root = Integer.valueOf(str.substring(0,i));
        while(i < str.length()){
            if(str.charAt(i) == ','){
                break;
            }
            i++;
        }
        return 0;
    }

}
