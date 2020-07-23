package com.分类题型.高级算法;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/7/23 12:47
 */
public class LRUByJava extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUByJava(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    public int get(int key){
        return super.getOrDefault(key, -1);
    }
    public void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
