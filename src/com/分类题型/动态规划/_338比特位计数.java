package com.分类题型.动态规划;

import com.tools.Print;

import java.util.Scanner;

/**
 * Description: 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * Created By @Author my on @Date 2020/5/25 18:05
 */
public class _338比特位计数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountBits proc = new CountBits();
        while(sc.hasNext()){
            int N = sc.nextInt();
            Print.printArray(proc.fun(N));
        }
    }
}
class CountBits {
    public int[] fun(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        if(num == 0){
            return res;
        }
        res[1] = 1;
        if(num == 1){
            return res;
        }
        res[2] = 1;
        if(num == 2){
            return res;
        }
        for(int i = 3; i <= num; i++){
            res[i] += res[i >> 1] + (i & 1);
        }
        return res;
    }
}
