package com.tools;


import java.util.LinkedList;
import java.util.List;

public class Print {

    public static<T> void listListPrint(List<List<T>> list){
        if(list == null || list.size() == 0){
            System.out.println("{}");
            return;
        }
        for(int i = 0; i < list.size(); i++){
            if(i == 0){
                System.out.print("{");
            }
            for(int j = 0; j < list.get(i).size(); j++){
                if(j == 0){
                    System.out.print("[" + list.get(i).get(j));
                }else if(j == list.get(i).size() - 1){
                    System.out.print("," + list.get(i).get(j) + "]");
                }else {
                    System.out.print("," + list.get(i).get(j));
                }
            }
            if(i == list.size() - 1){
                System.out.print("}");
            }
        }
        System.out.println();
    }
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
            System.out.print("   size:" + arr.length);
            System.out.println();
        }
    }

    public static void printTree(TreeNode root){
        List<Integer> list = new LinkedList<>();
        if(root == null){
            list.add(null);
            System.out.println(list);
            return;
        }
        Queue<TreeNode> queue = new Queue<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == null){
                list.add(null);
            } else{
                list.add(cur.val);
                if(cur.left == null && cur.right == null){
                    continue;
                }
                queue.offer(cur.left);
                queue.offer(cur.right);

            }
        }
        System.out.println(list);

    }

    public static void printNode(Node head){
        if(head == null){
            System.out.println("this Tree is null");
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
