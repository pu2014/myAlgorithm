package com.分类题型.链表;

public class LinkList {
    public class Node{
        public int val;
        public Node next;
    }

    public Node header = null;

    public LinkList() {
        this.header = new Node();
        this.header.val = 0;
        this.header.next = null;
    }

    public void insert(int obj){
        Node node = new Node();
        node.val = obj;
        if(header.next == null){
            header.next = node;
        }else {
            Node temp = header;
            while(temp.next != null){
                temp = temp.next;
            }
                temp.next = node;
        }
    }

    public void Delete(int obj){
        Node temp = header;
        while(temp.next != null){
            if(temp.next.val == obj){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public int getElement(int i){
        if(i < 1 && i > size()){
            throw new RuntimeException("输入参数有误！");
        }
        Node temp = header;
        while(i > 0){
            temp = temp.next;
            i--;
        }
        return temp.val;
    }

    public int size(){
        Node temp = header;
        int size = 0;
        while(temp.next != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
}
