package com.pu.链表;

import java.util.Arrays;

public class 单向链表左边小中间相等右边大 {
    /**
     * 给定一个单向链表的头文件head，节点的值类型是整型，输入一个整数poivot，
     * 实现调整链表的函数，左边小于中间等于右边大于，其他顺序不要求
     */
    public static void main(String[] args){
        Node header =new Node(0);
        Node node1 = new Node(9);
        header.next = node1;
        Node node2 = new Node(0);
        node1.next = node2;
        Node node3 = new Node(4);
        node2.next = node3;
        Node node4 = new Node(5);
        node3.next = node4;
        Node node5 = new Node(1);
        node4.next = node5;
        Node node = header.next;
        print(node);
        //Node head = arrListPartition(header,3);
        Node head = lessSpaceListPartition(header,3);
        print(head.next);

    }
    public static Node arrListPartition(Node head,int pivot){
        Node cur = head.next;
        int i = 0;
        while(cur != null){  // get the size of the Linklist
            i++;
            cur = cur.next;
        }
        int[] arr = new int[i];
        cur = head.next;
        for(int p = 0;p < i;p++){   //Load linked list elements into an array
            arr[p] = cur.val;
            cur = cur.next;
        }
        System.out.println(Arrays.toString(arr));
        arrPartition(arr,pivot);   // partition in the array
        System.out.println(Arrays.toString(arr));
        cur = head.next;
        for(int p = 0;p < i;p++){
            cur.val = arr[p];
            cur = cur.next;
        }
        return head;
    }

    public static void arrPartition(int[] array,int pivot){
        if(array.length == 0){
            return;
        }
        int sm = 0;  //the first coordinate
        int bi = array.length - 1;  // the last coordinate
        int i = 0;
        while(i < bi){
            if(array[i] < pivot){
                swap(array,sm++,i++);
            }else if(array[i] == pivot){
                i++;
            }else{
                swap(array,bi--,i);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static Node lessSpaceListPartition(Node head,int pivot) {
        if(head.next == null){
            return head;
        }
        Node sH = null;  //set the smaller head point
        Node sT = null;  //set the smaller tail point
        Node eH = null;  //set the equal head point
        Node eT = null;  //set the equal tail point
        Node bH = null;  //set the bigger head point
        Node bT = null;  //set the bigger tail point
        Node next = head.next;
        Node tmp;
        while(next != null){
            tmp = next.next;
            next.next = null;
            if(next.val < pivot){   //every node distributed to three lists
                if(sH == null){
                    sH = next;
                    sT = next;
                }{
                    sT.next = next;
                    sT = sT.next;
                }
            }else if(next.val == pivot){
                if(eH == null){
                    eH = next;
                    eT = next;
                }else{
                    eT.next = next;
                    eT = eT.next;
                }
            }else{
                if(bH == null){
                    bH = next;
                    bT = next;
                }else{
                    bT.next = next;
                    bT = bT.next;
                }
            }
            next = tmp;
        }
        //connect sm and eq
        if(sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        //connect all
        if(eT != null){
            eT.next = bH;
        }
        head.next = sH == null ? eH == null ? bH : eH : sH;
        return head;
    }

    public static void print(Node node){
        Node p = node;
        while(p != null){
            if (p.next == null) {
                System.out.println(p.val);
                p = p.next;
            } else {
                System.out.print(p.val + " --> ");
                p = p.next;
            }
        }
    }


}
