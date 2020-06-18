package com.笔试.IEEE;


import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/6/14 8:11
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int N = n;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i = 1; i < n; i++){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;
        int count = 0;
        while(n != 1){
            count = (int)(Math.pow(m, N - n + 1) - 2)%n;
            while(count-- > 0){
                head = head.next;
            }
            head.next = head.next.next;
            n--;
            head= head.next;
        }
        System.out.println(head.val + 1);
    }
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
