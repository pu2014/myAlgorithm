package com.剑指Offer;
import com.tools.Node;
import com.tools.Print;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/19 12:06
 */

public class _35两个链表的第一个公共结点 {
    public static void main(String[] args) {
        Node pHead1 = new Node(1);
        pHead1.next = new Node(2);
        pHead1.next.next = new Node(3);

        Node pHead2 = pHead1.next;

        Print.printNode(new FindFirstCommonNode().fun(pHead1,pHead2));
    }
}
class FindFirstCommonNode {
    public Node fun(Node pHead1, Node pHead2) {
        if(pHead1 == null || pHead2 == null) {
            return null;
        }
        Node p1 = pHead1;
        Node p2 = pHead2;
        while(p1 != null && p2 != null){
            if(p1.val == p2.val && p1.next == p2.next){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2){
                if(p1 == null){
                    p1 = pHead2;
                }
                if(p2 == null){
                    p2 = pHead1;
                }
            }
        }
        return null;
    }
}

