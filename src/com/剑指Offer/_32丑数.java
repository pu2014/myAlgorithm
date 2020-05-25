package com.剑指Offer;

import java.util.Scanner;

/**
 * @DESC 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @CREATE BY @Author pbj on @Date 2020/5/18 18:12
 */
public class _32丑数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        System.out.println(new GetUglyNumber_Solution().fun(index));
    }
}
class GetUglyNumber_Solution {
    public int fun(int index) {
        if(index < 7){
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        for(int i = 1; i < index; i++){
            res[i] = (Math.min(res[n2] * 2, Math.min(res[n3] * 3, res[n5] * 5)));
            if(res[i] == res[n2] * 2){
                n2++;
            }
            if(res[i] == res[n3] * 3){
                n3++;
            }
            if(res[i] == res[n5] * 5){
                n5++;
            }
        }
        return res[index - 1];
    }
}
