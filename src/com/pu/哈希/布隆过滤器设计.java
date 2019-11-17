package com.pu.哈希;

/**
 *
 * k 哈希函数个数  m 布隆过滤器长度 n 为插入的元素个数 p为误报率
 * 如何选择合适业务的k和m值呢？
 * m = - nlnp/(ln2)^2 上取整  （ln2）^2 = 0.48
 * k = (m/n)ln2   上取整
 *
 */

public class 布隆过滤器设计 {
    public static void main(String[] args){
        long[] arr = new long[100];  //int 4byte字节 32 位 100*64位bit

    }
}
