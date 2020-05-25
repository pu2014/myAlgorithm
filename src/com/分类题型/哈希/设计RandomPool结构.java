package com.分类题型.哈希;

import java.util.HashMap;

public class 设计RandomPool结构 {
    /**
     * 设计一种结构，在结构中有如下三个功能
     * insert(key):不重复
     * delete(key)：移除某个key
     * getRandom():等概率随机返回结构的任何一个key
     *
     * 每个方法时间复杂度为 O（1）
     */
    public static void main(String[] args){
        Pool<String> pool = new Pool<String>();
        pool.insert("datiangou");
        pool.insert("cimu");
        pool.insert("quanyecha");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }
    public static class Pool<K>{
        private HashMap<K,Integer> keyIndexMap;
        private HashMap<Integer,K> indexKeyMap;
        private int index;

        public Pool() {
            this.keyIndexMap = new HashMap<K,Integer>();
            this.indexKeyMap = new HashMap<Integer,K>();
            this.index = 0;
        }

        public void insert(K key){
            if(!this.keyIndexMap.containsKey(key)){
                this.keyIndexMap.put(key,this.index);
                this.indexKeyMap.put(this.index++,key);
            }
        }

        public K getRandom(){
            if(this.index == 0){
                return null;
            }
            int randomIndex = (int)(Math.random()*this.index);
            return this.indexKeyMap.get(randomIndex);
        }

        public void delete(K key){
            if(this.keyIndexMap.containsKey(key)){
                int deleteIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.index;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey,deleteIndex);
                this.indexKeyMap.put(deleteIndex,lastKey);

                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }
    }
}
