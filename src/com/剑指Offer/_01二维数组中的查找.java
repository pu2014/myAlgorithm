package com.剑指Offer;

/**
 * description：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author Pubojian
 * @date 2020/2/20 23:33
 */
public class _01二维数组中的查找 {
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3,4},
                {2,3,4,5},
                {5,6,7,8},
                {6,7,8,9}
        };
        int target = 3;
        System.out.println(find(target, mat));
    }

    public static boolean find(int target, int[][] mat){
        if(mat == null || mat.length == 0 || mat[0].length == 0){
            return false;
        }
        int row = 0;
        int col = mat[0].length - 1;
        while(row < mat.length && col >= 0){
            if(mat[row][col] == target){
                return true;
            }else if(mat[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}
