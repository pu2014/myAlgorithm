package com.笔试.huaweisx;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/6 19:34
 */
public class HWSXMain1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(-1);
        Node cur = head;
        String[] ss = sc.nextLine().split(" ");
        for(String s : ss){
            Integer n = Integer.valueOf(s);
            cur.next = new Node(n);
            cur = cur.next;
            cur.next = new Node(n);
            cur = cur.next;
            cur.next = new Node(n);
            cur = cur.next;
        }
        cur = head.next;
        while(cur != null){
            if(cur.next == null){
                System.out.print(cur.val);
                break;
            }
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();


    }

}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}