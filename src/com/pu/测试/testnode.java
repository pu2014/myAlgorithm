package com.pu.测试;



import com.tools.Node;
import com.tools.Print;

import javax.tools.Tool;

/**
 * description：test Node
 *
 * @author Pubojian
 * @date 2019/11/14 13:16
 */
public class testnode {
    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node0.next = node1;
        node0.next.next = node2;
        Node head = node0;
        while(node0.next != null){
            node0.val += 10;
            node0 = node0.next;
        }
        Node node3 = new Node(99);
        Print.printNode(head);
    }
}
