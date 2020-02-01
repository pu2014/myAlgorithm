package com.pu.树;

import com.tools.Node;
import com.tools.Print;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description：
 *
 * @author Pubojian
 * @date 2020/2/1 21:57
 */
public class 树的按层次遍历BFS {
    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right.right = new Node(5);
        Print.printTree(root);
        bfs(root);
    }

    private static void bfs(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.value + " ");
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
    }
}
