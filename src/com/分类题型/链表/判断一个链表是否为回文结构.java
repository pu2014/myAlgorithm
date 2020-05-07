package com.分类题型.链表;

import java.util.Stack;

/**
 * 给定一个链表的头结点head，请判断该链表是否为回文结构
 *
 * 例如：1->2->1 true
 *
 * 进阶：如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1);
 */
public class 判断一个链表是否为回文结构 {
    //空间复杂度O(n)
    public static boolean isHuiWen(LinkList list){
        LinkList.Node node1 = list.header;
        LinkList.Node node2 = list.header;
        LinkList.Node node = list.header.next;
        while(node2.next != null && node2.next.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
        }
        node1 = node1.next;
        Stack<Integer> stack = new Stack<>();
        while(node1.next != null){
            stack.push(node1.val);
            node1 = node1.next;
        }
            stack.push(node1.val);
        while(!stack.isEmpty()){
            System.out.print(stack.peek() + " " + node.val);
            System.out.println();
            if(stack.pop() != node.val){
                return false;
            }else{
                node = node.next;
            }
        }
        return true;
    }
    //空间复杂度为O(1)
    public static boolean lessSpaceIsHuiWen(LinkList list) {
        if(list.header.next == null){
            return false;
        }
        LinkList.Node fast = list.header.next;
        LinkList.Node slow = list.header.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }   //get the mid point
        LinkList.Node p = slow.next;  //p save the rigth points
        LinkList.Node tmp = null;
        slow.next = null;     //  mid point --> null
        while(p != null){
            tmp = p.next;   // tmp saves p' next node;
            p.next = slow;  // p --> slow -- > null;
            slow = p;       // slow move to p; slow' -->slow --> null;
            p = tmp;        // p.next;
        }
        LinkList.Node last = slow;   //slow is the last point; last sava the slow for recover list
        LinkList.Node first = list.header.next;  //the first point

        boolean res = true;  //set flag;
        while(slow != null && first != null){  //left to mid and rigth to mid
            System.out.println(slow.val + " " + first.val);
            if(slow.val != first.val){  //compare
                res = false;
                break;
            }
            first = first.next;
            slow = slow.next;
        }

        //recover list
        p = last.next;
        last.next = null;
        while(p != null){
            tmp = p.next;
            p.next = last;
            last = p;
            p = tmp;
        }
        return res;
    }


    public static void main(String[] args){
        LinkList list = new LinkList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(5);
       // list.insert(6);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        System.out.println(isHuiWen(list));
        System.out.println(lessSpaceIsHuiWen(list));
    }
}
