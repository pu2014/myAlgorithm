package com.pu.链表;


public class 打印两个有序链表的公共部分 {
    public static void main(String[] args){
        LinkList list1 = new LinkList();
        LinkList list2 = new LinkList();
        list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        list1.insert(5);
        list1.insert(6);
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);
        list2.insert(8);
        list2.insert(10);
        getTheSameElement(list1,list2);

    }

    public static void getTheSameElement(LinkList l1,LinkList l2){
        int p1 = 0;
        int p2 = 0;
        LinkList.Node node1 = l1.header;
        LinkList.Node node2 = l2.header;
        while(node1.next != null && node2.next != null){
            if(node1.next.val == node2.next.val){
                System.out.print(node1.next.val + " ");
                node1 = node1.next;
                node2 = node2.next;
            }else if(node1.next.val > node2.next.val){
                node2 = node2.next;
            }else{
                node1 = node1.next;
            }
        }
    }
}

