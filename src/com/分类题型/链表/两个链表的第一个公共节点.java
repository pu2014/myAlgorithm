package com.分类题型.链表;

/**
 * description：输入两个链表，找出它们的第一个公共结点。
 *
 * @author Pubojian
 * @date 2020/1/23 12:23
 */
public class 两个链表的第一个公共节点 {
    public static void main(String[] args) {
        Node pHead1 = new Node(1);
        pHead1.next = new Node(2);
        pHead1.next.next = new Node(3);
        Node pHead2 = new Node(2);
        pHead2.next = new Node(4);
        pHead2.next.next = new Node(6);
        pHead1.next.next.next = pHead2.next;

        System.out.println(FindFirstCommonNodeV1(pHead1, pHead2).val);
        System.out.println(FindFirstCommonNodeV2(pHead1, pHead2).val);
    }

    private static Node FindFirstCommonNodeV2(Node pHead1, Node pHead2) {
        /**
         * Description:如果两个链表有合并部分，则一定尾部一样，合并两个链表则可以实现链表的长度一致
         *  N + M
         * @auther
         */
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        Node cur1 = pHead1;
        Node cur2 = pHead2;
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
            if(cur1 != cur2){
                if(cur1 == null){
                    cur1 = pHead2;
                }
                if(cur2 == null){
                    cur2 = pHead1;
                }
            }
        }
        return cur1;
    }

    private static Node FindFirstCommonNodeV1(Node pHead1, Node pHead2) {
        /**
         * Description:最基本的思路，直接暴力遍历 n*m
         * @auther
         */
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        Node cur = null;
        while(pHead2 != null){
            cur = pHead1;
            while(cur != null){
                if(cur == pHead2){
                    return cur;
                }else{
                    cur = cur.next;
                }
            }
            pHead2 = pHead2.next;
        }
        return null;
    }
}
