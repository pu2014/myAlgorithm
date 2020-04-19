package com.pu.高级算法;

import java.util.BitSet;

/**
 * Description:布隆过滤器主要用于判断一个元素是否在一个集合中，它可以使用一个位数组简洁的表示一个数组。
 * 它的空间效率和查询时间远远超过一般的算法，但是它存在一定的误判的概率，适用于容忍误判的场景。如果布隆过滤器判断元素存在于一个集合中，
 * 那么大概率是存在在集合中，如果它判断元素不存在一个集合中，那么一定不存在于集合中。
 *
 * *** 常常被用于大数据去重
 * Created By @Author my on @Date 2020/4/9 15:54
 */
public class BloomFilter {
    //加法哈希算法，定义一个8个元素的质数数组（减少hash数组）
    private static final int[] primes = new int[]{2,3,5,7,11,13,17,19};
    //构建不同的八个hash算法
    class Hash {
        private int prime;

        public Hash(int prime) {
            this.prime = prime;
        }

        public int hash(String key) {
            int hash, i;
            for (hash = key.length(), i = 0; i < key.length(); i++) {
                hash += key.charAt(i);
            }
            return (hash % prime);
        }
    }
    private Hash[] hashList = new Hash[primes.length];

    //创建一个长度为10亿的比特位
    private BitSet bits = new BitSet(256 << 22);

    public BloomFilter() {
        for(int i = 0; i < primes.length; i++){
            //使用8个质数，创建8个方法
            hashList[i] = new Hash(primes[i]);
        }
    }

    //添加元素
    public void add(String value){
        for(Hash f : hashList){
            //算出8个的哈希值，对应到2的32次方个比特位上
            bits.set(f.hash(value), true);
        }
    }

    //判断是否在布隆过滤器中
    public boolean contains(String value){
        if(value == null){
            return false;
        }
        boolean res = true;
        for(Hash f : hashList){
           //查看8个比特位上的值
           res = res & bits.get(f.hash(value));
        }
        return res;
    }
}
