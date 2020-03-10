package com.tools;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/25 16:40
 */
public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    public static Node createNode(int len){
        Node head = new Node(-1);
        Node cur = head;
        for(int i = 0; i < len; i++){
            cur.next = new Node(i + 1);
            cur = cur.next;
        }
        return head.next;
    }

}
