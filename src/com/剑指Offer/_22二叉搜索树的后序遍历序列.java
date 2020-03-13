package com.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * description：
 *输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author Pubojian
 * @date 2020/3/13 10:08
 */
public class _22二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        int[] seq = {2, 4, 3, 7, 6, 5};
        int[] seq1 = {2, 4, 3, 10, 8, 9, 5};
        int[] seq2 = {2, 4, 3, 5};
        System.out.println(new VerifySquenceOfBST().method(seq));
        System.out.println(new VerifySquenceOfBST().method(seq1));
        System.out.println(new VerifySquenceOfBST().method(seq2));
        System.out.println(new VerifySquenceOfBST().func(seq));
        System.out.println(new VerifySquenceOfBST().func(seq1));
        System.out.println(new VerifySquenceOfBST().func(seq2));
    }

}
class VerifySquenceOfBST {
    public boolean method(int[] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        int len = sequence.length;
        //两个必然是后序遍历
        if(len < 3){
            return true;
        }
        //得到根节点
        int rootVal = sequence[len - 1];
        int L = -1;
        int R = len - 1;
        while(L < len - 1){
            if(sequence[L + 1] >= rootVal){
                break;
            }
            L++;
        }
        while(R > 0){
            if(sequence[R - 1] <= rootVal){
                break;
            }
            R--;
        }
        if(R != L + 1){
            return false;
        }else{
            if(L == -1){
                return method(Arrays.copyOfRange(sequence, R, len - 1));
            }else if(R == len - 1){
                return method(Arrays.copyOfRange(sequence, 0, L + 1));
            }else {
                return method(Arrays.copyOfRange(sequence, 0, L + 1))
                        && method(Arrays.copyOfRange(sequence, R, len - 1));
            }
        }
    }

    public boolean helpVerify(int [] sequence, int start, int root){
        if(start >= root)return true;
        int key = sequence[root];
        int i;
        //找到左右子数的分界点
        for(i=start; i < root; i++)
            if(sequence[i] > key)
                break;
        //在右子树中判断是否含有小于root的值，如果有返回false
        for(int j = i; j < root; j++)
            if(sequence[j] < key)
                return false;
        return helpVerify(sequence, start, i-1) && helpVerify(sequence, i, root-1);
    }
    public boolean func(int [] sequence) {
        if(sequence == null || sequence.length == 0)return false;
        return  helpVerify(sequence, 0, sequence.length-1);

    }
}