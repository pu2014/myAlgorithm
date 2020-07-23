package com.分类题型.高级算法;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 哈希链表 哈希表和双向链表实现
 * 查找快
 * 增删快
 * 有顺序
 * Created By @Author my on @Date 2020/4/9 14:20
 */
public class LRUCache {
    DoubleList cache;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        cache = new DoubleList();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = map.get(key);
            put(key, node.val);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        //要调整位置插入至最前面（
        //可能是调用了get这个key于是我们要把这个Node放到队尾
        //也可能是put了一个新值，只不过key相同，这时就要更改下key对应的valua在这里我们是直接换一个DoubleNode去插入）
        if(map.containsKey(key)){
            Node last = map.get(key);
            cache.remove(last);
            cache.addFirst(newNode);
            //如果值更新了
            map.put(key, newNode);
        }else{
            if(capacity == cache.size()){
                //这里不光要把队尾去掉，也要把map中的key和DoubleNode的映射去掉
                //这里也是为什么DoubleNode中要有key的原因，
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(newNode);
            map.put(key, newNode);
        }

    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
    }

}

/**
 * 双向链表的节点类
 */
class Node{
    public int key, val;
    public Node next, prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleList {
    private Node head;
    private Node tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表头部添加节点node，时间 O(1)
    public void addFirst(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    // 删除链表中的 node 节点（node 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node node){
        if(size == 0){
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    // 删除链表中最后一个节点，并返回该节点，时间 O(1)
    public Node removeLast(){
        if(size == 0){
            return null;
        }
        //找到最后的的一个元素
        Node node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        size--;
        return node;
    }

    // 返回链表长度，时间 O(1)
    public int size(){
        return size;
    }
}
