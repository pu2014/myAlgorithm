package com.分类题型.数字.进制转换;

/**
 * description：求为求一个数的二进制表示中最右边1所对应的值（lowBit)
 * 即2^k k 为末尾0的数量
 *
 * 运用：树状数组
 *
 * @author Pubojian
 * @date 2020/3/8 17:57
 */
public class 为求一个数的二进制表示中最右边1所对应的值 {
    public static void main(String[] args) {
        System.out.println(new LowBit().fun1(6));
        System.out.println(new LowBit().fun1(9));
        System.out.println(new LowBit().fun1(8));
        System.out.println(new LowBit().fun2(6));
        System.out.println(new LowBit().fun2(9));
        System.out.println(new LowBit().fun2(8));
    }
}
class LowBit{
    /**
     * 系统自带的方法直接返回
     * @param num
     * @return
     */
    public int fun1(int num){
        return 1 << (Integer.numberOfTrailingZeros(num));
    }
    public int fun2(int num){
        return num & (-num);
    }
}

