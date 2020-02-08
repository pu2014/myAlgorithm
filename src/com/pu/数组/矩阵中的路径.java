package com.pu.数组;

import java.util.Stack;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/7 18:45
 */
public class 矩阵中的路径 {
    public static void main(String[] args) {
        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SGGFIECVAASABCEHJIGQEM".toCharArray();
        int rows = 5;
        int cols = 8;
        System.out.println(hasPath(matrix, rows, cols, str));
    }
    public static  boolean hasPath(char[] mat, int rows, int cols, char[] str){
        if(mat == null || rows < 1 || cols < 1 || rows * cols != mat.length || mat.length < str.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] isVis = new boolean[mat.length];
        int i = 0;
        int j = 0;
        int m = -1;
        while(i < mat.length && j < str.length){
            if(j == 0){
                if(!isVis[i] && mat[i] == str[j]){
                    stack.push(i);
                    if(m > -1){
                        isVis[m] = false;
                    }
                    isVis[i] = true;
                    j++;
                }else{
                    i++;
                }
            }else{
                int k = stack.peek();
                if(k - cols >= 0 && !isVis[k - cols] && mat[k - cols] == str[j]){
                    stack.push(k - cols);
                    isVis[m] = false;
                    isVis[k - cols] = true;
                    j++;
                    continue;
                }
                if(k % cols != 0 && !isVis[k - 1] && mat[k - 1] == str[j]){
                    stack.push(k - 1);
                    isVis[m] = false;
                    isVis[k - 1] = true;
                    j++;
                    continue;
                }
                if(k % cols != cols - 1 && !isVis[k + 1] && mat[k + 1] == str[j]){
                    stack.push(k + 1);
                    isVis[m] = false;
                    isVis[k + 1] = true;
                    j++;
                    continue;
                }
                if(k + cols < mat.length && !isVis[k + cols] && mat[k + cols] == str[j]){
                    stack.push(k + cols);
                    isVis[m] = false;
                    isVis[k + cols] = true;
                    j++;
                    continue;
                }
                if(m > -1){
                    isVis[m] = false;
                }
                m = stack.pop();

                j--;
            }
        }
        return j == str.length;
    }
}
