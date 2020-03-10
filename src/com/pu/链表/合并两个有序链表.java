package com.pu.链表;

public class 合并两个有序链表 {
    static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);

        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);


        print(list1);
        print(list2);
        print(createdNodeMerge(list1, list2));

        //ListNode list3 = merge(list1,list2);
        //ListNode list4 = recurMerge(list1,list2);
        //print(list3);
        //print(list1);
        //print(list2);
        //System.out.println("递归版本");
        //print(list4);

    }
    private static ListNode createdNodeMerge(ListNode list1, ListNode list2){
        /**
         * Description:直接生成新元素
         * @auther pubojian
         */
        ListNode head = new ListNode(0);
        ListNode node = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                node.next = new ListNode(list1.val);
                node = node.next;
                list1 = list1.next;
            }else{
                node.next = new ListNode(list2.val);
                node = node.next;
                list2 = list2.next;
            }
        }
        node.next = list1 == null ? list2 : list1;
        return head.next;
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                node.next = list1;
                list1 = list1.next;
            }else{
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
//        if(list1 != null){
//            node.next = list1;
//        }
//        if(list2 != null){
//            node.next = list2;
//        }可以简化
        node.next = list1 == null ? list2 : list1;

        return head.next;//return list1 or list2
    }

    public static ListNode recurMerge(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = recurMerge(list1.next, list2);
            return list1;
        }else{
            list2.next = recurMerge(list1, list2.next);
            return list2;
        }
    }

    public static void print(ListNode head){
        if(head == null){
            return;
        }
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
            System.out.println();
    }
}
