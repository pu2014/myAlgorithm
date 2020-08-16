package com.剑指Offer;

/**
 * @DESC请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 [abcesfcsadee]\begin{bmatrix}
 * a & b & c &e \\ s & f & c & s \\ a & d & e& e\\ \end{bmatrix}\quad⎣⎡​asa​bfd​cce​ese​⎦⎤​
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * @CREATE BY @Author pbj on @Date 2020/8/16 22:31
 */
public class _57矩阵中的路径 {
    public static void main(String[] args) {
        char[][] mat = {{'a','b','c','e'},
                        {'s','f','c','s'},
                        {'a','d','e','e'}};
        char[] chs = {'b','c','c','e','d'};
        System.out.println(hasPath(mat, chs));
    }
    private static boolean res = false;
    private static boolean hasPath(char[][] mat, char[] chs) {
        boolean[][] isVis = new boolean[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == chs[0]) {
                    dfs(mat, i, j , 0, chs, isVis);
                    if (res == true) {
                        return true;
                    }
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] mat, int i, int j, int inx, char[] chs, boolean[][] isVis) {
        if(inx >= chs.length){
            res = true;
            return;
        }
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || isVis[i][j] || chs[inx] != mat[i][j]){
            return;
        }
        isVis[i][j] = true;
        dfs(mat, i + 1, j, inx + 1, chs, isVis);
        dfs(mat, i - 1, j, inx + 1, chs, isVis);
        dfs(mat, i, j - 1, inx + 1, chs, isVis);
        dfs(mat, i, j + 1, inx + 1, chs, isVis);
        isVis[i][j] = false;
    }
}
