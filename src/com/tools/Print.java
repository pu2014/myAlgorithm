package com.tools;

import com.pu.链表.Node;
import com.tools.Print;

public class Print {
    public static void printArray(Integer[] arr){
        if(arr.length == 0){
            System.out.println("This array is empty");
            return;
        }else{
            System.out.print("[");
            int i = 0;
            for(;i < arr.length - 1;i++){
                System.out.print(arr[i] + ", ");
            }
            System.out.print(arr[i] +"]");
            System.out.print("   size:" + i);
            System.out.println();
        }
    }
    public static void printArray(int[] arr){
        if(arr.length == 0){
            System.out.println("This array is empty");
            return;
        }else{
            System.out.print("[");
            int i = 0;
            for(;i < arr.length - 1;i++){
                System.out.print(arr[i] + ", ");
            }
            System.out.print(arr[i] +"]");
            System.out.print("   size:" + i);
            System.out.println();
        }
    }

    public static void printTree(com.tools.Node root){
        printTreeHelper(root);
        System.out.println();
    }

    private static void printTreeHelper(com.tools.Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.value + " ");
        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }

    public static void printNode(Node head){
        if(head == null){
            System.out.println("this LinkedList is null");
        }else{
            while(head != null){
                if(head.next == null){
                    System.out.print(head.val);
                    System.out.println();
                    break;
                }
                System.out.print(head.val + "-->");
                head = head.next;
            }

        }
    }
}
