package com.LeetCode;

/**
 * description：反转链表
 * 题目1：反转整个链表
 *      反转链表
 * 题目2：两两交换链表中的节点
 *      给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 题目3：K 个一组翻转链表
 *      给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *      k 是一个正整数，它的值小于或等于链表的长度。
 *      如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *      示例 :
 *      给定这个链表：1->2->3->4->5
 *      当 k = 2 时，应当返回: 2->1->4->3->5
 *      当 k = 3 时，应当返回: 3->2->1->4->5
 *      说明 :
 *      你的算法只能使用常数的额外空间。
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author Pubojian
 * @date 2020/2/24 14:02
 */
public class _04K个一组元素的链表的反转 {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        print(head1);
        Node reverseNode = reverse(head1);
        print(reverseNode);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);

        print(head2);
        Node swapNode = swapPairs(head2);
        print(swapNode);


        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        head3.next.next.next = new Node(4);

        print(head3);
        Node swapNodeNoRec = swapPairsNonRecur(head3);
        print(swapNodeNoRec);


        Node head4 = new Node(1);
        head4.next = new Node(2);
        head4.next.next = new Node(3);
        head4.next.next.next = new Node(4);
        head4.next.next.next.next = new Node(5);
        head4.next.next.next.next.next = new Node(6);

        print(head4);
        int k = 4;
        Node reverseKGroupNoRec = reverseKGroupNoRec(head4, k);
        print(reverseKGroupNoRec);


        Node head5 = new Node(1);
        head5.next = new Node(2);
        head5.next.next = new Node(3);
        head5.next.next.next = new Node(4);
        head5.next.next.next.next = new Node(5);
        //head5.next.next.next.next.next = new Node(6);

        print(head5);
        System.out.println("k-->" + k);
        Node reverseKGroupTailIn = reverseKGroupTailIn(head5, 2);
        print(reverseKGroupTailIn);



    }

    private static Node reverseKGroupTailIn(Node head, int k) {
        Node newHead = new Node(-1);
        newHead.next = head;
        Node pre = newHead;
        Node tail = newHead;
        Node cur = null;
        while(true){
            int count = 0;
            while(tail != null && count < k){
                tail = tail.next;
                count++;
            }
            if(tail == null){
                break;
            }
            Node temp = pre.next; //记录pre下一个位置，反转后就是最后面的位置
            while(pre.next != tail){
                cur = pre.next; //将pre后面的取出来
                pre.next = cur.next;//将pre后一个移走，链接下一个
                cur.next = tail.next; //接到最尾部
                tail.next = cur;  //tail 尾部接新来的
            }
            pre = temp; //返回到下一个位置
            tail = temp;
        }
        return newHead.next;
    }

    private static Node reverseKGroupNoRec(Node head, int k) {
        Node cur = head;
        int count = 0;
        while(cur != null && count < k){
            cur = cur.next;
            count++;
        }
        if(count == k){
            //recur
            cur = reverseKGroupNoRec(cur, k);
            while(count > 0){
                count--;
                //swap : use cur point as new head;
                Node next = head.next;
                head.next = cur;
                cur = head; //new head;
                head = next; //move
            }
            head = cur; //update the head;
        }
        return head;
    }

    private static Node swapPairs(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    private static Node swapPairsNonRecur(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node oneStep;
        Node twoStep;
        Node newHead = new Node(-1);
        newHead.next = head;
        Node cur = newHead;
        while(head != null && head.next != null){
            oneStep = head;
            twoStep = head.next;
            //swap
            cur.next = twoStep;
            oneStep.next = twoStep.next;
            twoStep.next = oneStep;
            //renew
            cur = oneStep;
            head = head.next;
        }
        return newHead.next;
    }

    private static Node reverse(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node next;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static void print(Node head) {
        while(head != null){
            System.out.print(head.val  + " ");
            head = head.next;
        }
        System.out.println();
    }


}
