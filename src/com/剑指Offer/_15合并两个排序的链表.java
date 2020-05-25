package com.剑指Offer;

import com.tools.ListNode;
import com.tools.Print;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/3/9 8:54
 */
public class _15合并两个排序的链表 {
    public static void main(String[] args) {
        ListNode list1 = ListNode.createListNode(3);
        ListNode list2 = ListNode.createListNode(5);
        Print.printNode(new MergeTwoLists().Merge(list1, list2));
    }
}
class MergeTwoLists {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
