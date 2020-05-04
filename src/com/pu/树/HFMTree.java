package com.pu.树;

import java.util.Arrays;
import java.util.Comparator;


public class HFMTree {
    public static class Node<E>{
        E data;
        double weight;
        Node lChild;
        Node rChild;
        String cd;
        Node(E data,double weight){
            super();
            this.data = data;
            this.weight = weight;
            this.weight = weight;
            this.cd = "";
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
    }
    public static Node createdTree(Node[] nodes){
        while(nodes.length > 1){
            Arrays.sort(nodes,new NodeComparator());
            Node left = nodes[nodes.length - 1];
            left.cd = "0";
            Node right = nodes[nodes.length - 2];
            right.cd = "1";
            Node parent = new Node(null,left.weight + right.weight);
            parent.lChild = left;
            parent.rChild = right;
            Node [] newNodes = Arrays.copyOfRange(nodes,0,nodes.length - 1);
            newNodes[nodes.length - 2] = parent;
            nodes = newNodes;
        }
        return nodes[0];
    }
    public static class NodeComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return (int)(o2.weight - o1.weight);
        }
    }
    public static void show(Node root){
        if(root == null) return;
        System.out.println(root);
        show(root.lChild);
        show(root.rChild);
    }
    public static void showCode(Node root){
        if(root == null){
            return;
        }
        if(root.data != null){
            System.out.println(root.data + "--com.coding--" + root.cd);
        }
        showCode(root.lChild);
        showCode(root.rChild);
    }
    public static void code(Node root){
        if(root.lChild != null){
            root.lChild.cd = root.cd + root.lChild.cd;
            code(root.lChild);
        }
        if(root.rChild != null){
            root.rChild.cd = root.cd + root.rChild.cd;
            code(root.rChild);
        }
    }

    public static void main(String[] args) {
        Node [] nodes = {new Node("a",50),new Node("b",80),new Node("c",20)};
        Node root = createdTree(nodes);
        show(root);
        code(root);
        showCode(root);

    }
}
