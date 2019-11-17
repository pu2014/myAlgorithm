package com.pu.树;

/**
 * Morris遍历细节 假设来到当前节点cur，开始时cur来到头节点位置
 *
 * 1）如果cur没有左孩子，cur向右移动(cur = cur.right)
 *
 * 2）如果cur有左孩子，找到左子树上最右的（为空或者指向自己终止）节点mostRight：     
 *
 * while (mostRight.right != null && mostRight.right != cur) {
 *                     mostRight = mostRight.right;
 *                 }
 *       a.如果mostRight的右指针指向空，让其指向cur，   
 *         然后cur向左移动(cur = cur.left)     
 *
 *       b.如果mostRight的右指针指向cur，让其指向null，   
 *         然后cur向右移动(cur = cur.right)
 *
 * 3）cur为空时遍历停止
 *
 */

public class 树的moris遍历 {
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void morisPre(Node head){
        if(head == null){
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        boolean preflag = false;
        while(cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while(cur2.right != null && cur2.right != cur1){
                    //找到cur1的左子树最右的节点。
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    if(preflag == false) {
                        System.out.print("preTraval:");
                        preflag = true;
                    }
                    System.out.print(cur1.value + " ");
                    cur1 = cur1.left;
                    continue;
                }else{
                    cur2.right = null;
                }
            }else{
                System.out.print(cur1.value + " ");
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }


    private static void morisIn(Node head) {
        if(head == null){
            return;
        }
        Node cur = head;
        Node tmp;
        boolean inflag = false;
        while(cur != null){
            tmp = cur.left;
            if(tmp != null){
                while(tmp.right != null && tmp.right != cur){
                    tmp = tmp.right;  //mostRight;
                }
                if(tmp.right == null){
                    tmp.right = cur;
                    cur = cur.left;
                    continue;
                }
                if(tmp.right == cur){
                    tmp.right = null;
                }
            }

            //当节点准备向右子树时，打印此节点。
            if(inflag == false) {
                System.out.print("inTraval:");
                inflag = true;
            }
            System.out.print(cur.value + " ");


            cur = cur.right; //左子树为空就指向右边。
        }
        System.out.println();

    }

    private static void morisPos(Node head) {  //时间复杂度O(n)
        if(head == null){
            return;
        }
        Node cur = head;
        Node tmp;
        boolean posflag = false;
        while(cur != null){
            tmp = cur.left;
            if(tmp != null){
                while(tmp.right != null && tmp.right != cur){
                    tmp = tmp.right;
                }
                if(tmp.right == null){
                    tmp.right = cur;
                    cur = cur.left;
                    continue;
                }
                if(tmp.right == cur){
                    tmp.right = null;
                    if(posflag == false){
                        System.out.print("posTraval:");
                        posflag = true;
                    }
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();

    }

    private static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while(cur != null){
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        //reverseEdge(tail);
    }

    private static Node reverseEdge(Node head) {
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.right;
            head.right = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        morisPre(head);
        morisIn(head);
        morisPos(head);


    }
}
