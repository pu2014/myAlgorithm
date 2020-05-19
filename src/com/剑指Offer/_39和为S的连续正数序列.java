package com.剑指Offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @DESC 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * @CREATE BY @Author pbj on @Date 2020/5/19 16:18
 */
public class _39和为S的连续正数序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        FindContinuousSequence proc = new FindContinuousSequence();
        System.out.println(proc.fun(sum));
    }
}
class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> fun(int sum) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        if(sum < 2){
            return res;
        }
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        for(int i = 1; i <= sum / 2 + 1; i++){
            count += i;
            deque.addLast(i);
            if(count > sum) {
                while (count > sum) {
                    count -= deque.pollFirst();
                }
            }
            if(count == sum){
                res.add(new ArrayList<>(deque));
            }
        }
        return res;
    }
}
