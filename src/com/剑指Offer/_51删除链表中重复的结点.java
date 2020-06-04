package com.剑指Offer;

import com.tools.ListNode;
import com.tools.Print;

import java.util.Scanner;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/5/21 15:57
 */
public class _51删除链表中重复的结点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeleteDuplication proc= new DeleteDuplication();
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] nums = new int[N];
            for(int i = 0; i < N; i++){
                nums[i] = sc.nextInt();
            }
            ListNode head = ListNode.createListNode(nums);
            Print.printNode(head);
            Print.printNode(proc.fun(head));
        }
    }
}
class DeleteDuplication {
    public ListNode fun(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        newHead.next = pHead;
        ListNode cur = newHead;
        ListNode same = newHead;
        while(cur.next != null){
            same = cur.next;
            if(same.next != null && same.next.val == same.val){
                while(same.next != null){
                    if(same.val == same.next.val){
                        same = same.next;
                    }else{
                        break;
                    }
                }
                cur.next = same.next;
            }else{
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}