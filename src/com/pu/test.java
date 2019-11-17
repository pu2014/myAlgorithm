package com.pu;

import com.pu.链表.Node;
import com.tools.Print;

import java.util.*;


public class test {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node node = head.next.next.next.next;
        Print.printNode(node);
        node.next = null;
        Print.printNode(node);
        Node res = getNode(head,4);
        Print.printNode(res);
        res.next = null;
        Print.printNode(head);

        Node t1 = new Node(0);


        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        Collections.sort(list);
        for(Integer i : list){
            System.out.println(i);
        }

        int [] pushA = {1,2,3,4,5};
        int [] popA = {5,4,3,2,1};
        System.out.println(IsPopOrder(pushA , popA));
        System.out.println(Arrays.toString(popA));
        Stack<Integer> s = new Stack<>();
        s.push(2);
        s.empty();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(23);
        for(Integer i : queue){
            System.out.println(i);
        }




    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int mid = popA.length >> 1;
        int help;
        for(int i = 0; i < mid; i++){
            help = popA[i];
            popA[i] = popA[popA.length - 1 - i];
            popA[popA.length - 1 - i] = help;
        }
        for(int i = 0; i < popA.length; i++){
            if(pushA[i] != popA[i]){
                return false;
            }
        }
        return true;
    }

    private static Node getNode(Node head, int i) {
        if(head == null){
            return null;
        }
        while(head != null){
            if(head.val == 4){
                return head;
            }
            head = head.next;
        }
        return null;
    }


}
