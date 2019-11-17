package com.pu.树;

import com.tools.Tree;

public class 树的递归遍历 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(44);
        tree.insert(55);
        tree.insert(33);
        tree.insert(66);
        Tree.Node head = tree.root;
        preOrderRecur(head);
        System.out.println();
        inOrderRecur(head);
        System.out.println();
        posOrderRecur(head);
        System.out.println();
    }

    public static void preOrderRecur(Tree.Node head){
        if(head == null){
            return;
        }
        System.out.print(head.data + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Tree.Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.data + " ");
        inOrderRecur(head.right);

    }

    public static void posOrderRecur(Tree.Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.data + " ");


    }
}
