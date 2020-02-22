package com.剑指Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * description：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * @author Pubojian
 * @date 2020/2/22 23:32
 */
public class _03从头到尾打印链表 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ArrayList<Integer> list = printListFromTailToHead(head);
        System.out.println(list.toString());

        ArrayList<Integer> listRec = printListFromTailToHeadRecursive(head);
        System.out.println(listRec.toString());
    }


    public static ArrayList<Integer> printListFromTailToHead(ListNode node) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    static ArrayList<Integer> listRecursive = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHeadRecursive(ListNode node) {
        if (node != null) {
            printListFromTailToHeadRecursive(node.next);
            listRecursive.add(node.val);
        }
        return listRecursive;
    }
}