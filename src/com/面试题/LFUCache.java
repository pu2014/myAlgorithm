package com.面试题;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @DESC    首先要维持一个缓存的map还要维持一个访问次数以及时间的map
 * @CREATE BY @Author pbj on @Date 2020/7/29 10:52
 */
public class LFUCache<K, V> {
    private final int capcity;
    private Map<K, V> cache = new HashMap<>();
    private Map<K, HitRate> count = new HashMap<>();
    public LFUCache(int capcity){
        this.capcity = capcity;
    }

    public void put(K key, V value){
        V v = cache.get(key);
        if(v == null){
            if(cache.size() == capcity){
                this.removeElement();
            }
            count.put(key, new HitRate(key, 1, System.nanoTime()));
        }else{
            this.addHitCount(key);
        }
        cache.put(key, value);
    }

    public V get(K key){
        V value = cache.get(key);
        if(value != null){
            addHitCount(key);
            return value;
        }
        return null;
    }

    private void addHitCount(K key) {
        HitRate hitRate = count.get(key);
        hitRate.hitCount++;
        hitRate.lastTime = System.nanoTime();
    }

    private void removeElement() {
        HitRate hr = Collections.min(count.values());
        cache.remove(hr.key);
        count.remove(hr.key);
    }


    class HitRate implements Comparable<HitRate>{

        private K key;
        private int hitCount;
        private long lastTime;

        public HitRate(K key, int hitCount, long lastTime) {
            this.key = key;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }

        @Override
        public int compareTo(HitRate o) {
            int compare = Integer.compare(this.hitCount, o.hitCount);
            return compare == 0 ? Long.compare(this.lastTime, o.lastTime) : compare;
        }
    }

}
