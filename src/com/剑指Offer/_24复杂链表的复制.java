package com.剑指Offer;

import java.util.*;
/**
 * Description:
 * Created By @Author my on @Date 2020/4/20 0:04
 */
public class _24复杂链表的复制 {
    public static void main(String[] args) {
        RandomListNode pHead = new RandomListNode(1);
        RandomListNode second = new RandomListNode(2);
        RandomListNode third = new RandomListNode(3);
        pHead.next = second;
        second.next = third;
        pHead.random = third;
        third.random = second;

        print(pHead);
        print(new RandomListNodeClone().method(pHead));
    }

    private static void print(RandomListNode pHead) {
        RandomListNode cur = pHead;
        System.out.print("顺序：");
        while(cur != null){
            System.out.print(cur.label);
            cur = cur.next;
        }
        System.out.println();

        cur = pHead;
        System.out.print("顺序：");
        while(cur != null){
            System.out.print(cur.label);
            cur = cur.random;
        }
        System.out.println();
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

class RandomListNodeClone {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while(cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
    public RandomListNode method(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        RandomListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = pHead;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode root = cur.next;
        while (cur != null) {
            next = cur.next;
            cur.next = next.next;
            next.next = cur.next == null ? null : cur.next.next;
            cur = cur.next;

        }
        return root;
    }
}