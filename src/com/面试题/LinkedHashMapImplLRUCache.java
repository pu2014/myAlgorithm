package com.面试题;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @DESC LRU Cache 最近最少使用
 * @CREATE BY @Author pbj on @Date 2020/5/13 10:03
 */
public class LinkedHashMapImplLRUCache<K,V> extends LinkedHashMap<K,V> {
    private int limit;

    /**
     * accessOrder： 默认为false，按照插入顺序。 true 安装读取顺序
     * @param capacity
     */
    public LinkedHashMapImplLRUCache(int capacity){
        super(capacity, 0.75f, true);
        limit = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }

    public static void main(String[] args) {
        LinkedHashMapImplLRUCache<Integer, Integer> lru = new LinkedHashMapImplLRUCache<>(4);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);
        lru.put(6, 6);
        lru.put(7, 7);
        lru.put(8, 8);
        Iterator<Map.Entry<Integer, Integer>> it = lru.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Integer> next = it.next();
            System.out.println(next.getKey() + " --> " + next.getValue());
        }

        System.out.println(lru.get(6));
        System.out.println(lru.get(5));
        Iterator<Map.Entry<Integer, Integer>> it2 = lru.entrySet().iterator();
        while(it2.hasNext()){
            Map.Entry<Integer, Integer> next = it2.next();
            System.out.println(next.getKey() + " --> " + next.getValue());
        }
    }
}
