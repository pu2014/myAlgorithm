package com.pu.链表;

import java.util.HashMap;

public class 复制含有随机指针结点的链表 {
    public static class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int data){
            this.value = data;
        }
    }
    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next;  // 1-->6
        head.next.rand = head.next.next.next.next.next;  // 2-->6
        head.next.next.rand = head.next.next.next.next;  // 3-->5
        head.next.next.next.rand = head.next.next;  // 4-->3
        head.next.next.next.next.rand = null;  // 5-->null
        head.next.next.next.next.next.rand = head.next.next.next;  // 6-->4

        printRandLinkedList(head);
        Node res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        Node res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        Node res3 = copyListWithRand2ByZuo(head);
        printRandLinkedList(res3);

    }

    private static void printRandLinkedList(Node head) {
        Node cur = head;
        while(cur != null){
            if(cur.next == null){
                if(cur.rand != null) {
                    System.out.print(cur.value + "[" + cur.rand.value + "]");
                    System.out.println();
                }else{
                    System.out.print(cur.value + "[null]");
                    System.out.println();
                }
            }else{
                if(cur.rand != null){
                    System.out.print(cur.value + "[" + cur.rand.value + "]" + " --> ");
                }else{
                    System.out.print(cur.value + "[null]" + " --> ");
                }
            }
            cur = cur.next;
        }
    }

    //use hashmap
    public static Node copyListWithRand1(Node head){
        Node cur = head;
        HashMap<Node,Node> map = new HashMap<>();   // Use map to achieve one-to-one correspondence
        while(cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //no hashMap
    public static Node copyListWithRand2(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next;
        while(cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        cur = head;

        while(cur != null){
            cur.next.rand = cur.rand == null ? null : cur.rand.next;
            cur = cur.next.next;
        }

        cur = head;
        Node res = head.next;
        while(cur != null){
            next = cur.next;
            cur.next = next.next;
            next.next = next.next == null ? null : next.next.next;
            cur = cur.next;
        }
        return res;
    }

    public static Node copyListWithRand2ByZuo(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;

        while(cur != null){
            //1注意这两个指针的变化
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
            /*
            //2
            Node node = new Node(cur.value);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
            */
        }
        cur = head;
        while(cur != null){
            if(cur.rand != null) {
                cur.next.rand = cur.rand.next;
            }
            cur = cur.next.next;
        }
        Node curCopy = null;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand == null ? null : cur.rand.next;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }

        return res;
    }


}
