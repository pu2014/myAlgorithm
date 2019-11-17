package com.pu.树;

import com.tools.Tree;

import java.util.Stack;

/**
 * 思想：
 * 前序：中左右   中进栈弹出打印再进右节点、左节点 打印
 * 中序：左中右   （纸的折叠）当前进栈节点不为空，进左节点，当当前节点为空时，打印当前节点，进右节点。
 * 后序：左右中   将前序变成中右左再反向，。，
 */


public class 树的非递归遍历 {
    public static void main(String[] args){
        Tree t = new Tree();
        t.insert(66);
        t.insert(45);
        t.insert(56);
        t.insert(73);
        t.insert(89);
        t.insert(35);
        t.insert(68);
        t.insert(80);
        Tree.Node head = t.root;
        preOrderRecur(head);
        inOrderRecur(head);
        posOrderRecur(head);
    }

    private static void posOrderOnlyOneStack(Tree.Node head){
        System.out.print("proOrder：");
        if(head != null){
            Stack<Tree.Node> stack = new Stack<>();
            stack.push(head);
            Tree.Node cur = null;
            while(!stack.isEmpty()){
                cur = stack.peek();
                if(cur.left != null && cur.left != head && cur.right != head){
                    stack.push(cur.left);
                }else if(cur.right != null && head != cur.right){
                    stack.push(cur.right);
                }else{
                    System.out.print(stack.pop().data + " ");
                    head = cur;
                }
            }
        }
        System.out.println();
    }

    private static void posOrderRecur(Tree.Node head) {
        System.out.print("posOrder: ");
        Stack<Tree.Node> stack = new Stack<>();
        Stack<Tree.Node> rever = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            rever.push(head);
            if(head.left != null){
                stack.push(head.left);
            }
            if(head.right != null){
                stack.push(head.right);
            }
        }
        while(!rever.isEmpty()){
            System.out.print(rever.pop().data + " ");
        }
        System.out.println();

    }


    private static void inOrderRecur(Tree.Node head) {
        System.out.print("inOrder: ");
        Stack<Tree.Node> stack = new Stack<>();
        if(head != null){
            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.data + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void preOrderRecur(Tree.Node head){
        System.out.print("preOrder: ");
        if(head != null){
            Stack<Tree.Node> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.data + " ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }
}
