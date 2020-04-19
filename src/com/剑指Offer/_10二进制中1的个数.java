package com.剑指Offer;

/**
 * description：
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 在机器中，整数的存储和运算都是其补码表示的。
 *
 * 正数右移：保持为正数，相当于/2。
 *
 * 负数右移：保持为负数，移位前是负数，移位后保持是负数，因此移位后最高位设为1。如果一直右移，最终会变成-1，即(-1)>>1是-1。
 *
 * 正数左移：不保持为正数，相当于*2。（注意：1左移31时为负数最大值）
 *
 * 负数左移：不保持为负数，在左移的过程中会有正有负的情况。所以切记负数左移不会特殊处理符号位。如果一直左移，最终会变成0。
 * @author Pubojian
 * @date 2020/2/29 16:50
 */
public class _10二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(Integer.bitCount(-1));
        NumberOf1 n = new NumberOf1();
        System.out.println(n.fun1(-1));
        System.out.println(n.fun2(-1));
        System.out.println(n.fun3(-1));
    }
}
class NumberOf1 {

    //求与  011 & 100 == 000 100 只有一个1
    public int fun1(int n) {
        int res = 0;
        while(n != 0){
            res++;
            n = n & (n - 1);
        }
        return res;
    }

    public int fun2(int n) {
        int res = 0, flag = 1;
        while(flag != 0){
            if((flag & n) != 0){
                res++;
            }
            flag = flag << 1;
        }
        return res;
    }

    public int fun3(int n) {
        int res = 0;
        while(n != 0){
            if((n & 1) == 1){
                res++;
            }
            n = n >>> 1;
        }
        return res;
    }
}
