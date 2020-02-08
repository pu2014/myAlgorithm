package com.tools;

public class Tree {
    private int count = 0;
     public Node root;

    public class Node{
        public int data;
        public Node left;
        public Node  right;
        public Node(int data){
            this.data = data;
        }
    }


    public void preOrderRecur(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public  void inOrderRecur(Node root){
        if(root == null){
            return;
        }else {
            inOrderRecur(root.left);
            System.out.print(root.data + " ");
            inOrderRecur(root.right);
        }

    }

    public void posOrderRecur(Node root){
        if(root == null){
            return;
        }
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.data + " ");


    }

    public Node find(int num){
        Node cur = root;
        while(cur != null){
            if(cur.data > num){
                cur = cur.left;
            }else if(cur.data < num){
                cur = cur.right;
            }else{
                return cur;
            }
        }
        return null;

    }

    public boolean insert(int data){
        count++;
        Node node = new Node(data);
        if(root == null){
            root = node;
            return true;
        }
        Node cur = root;
        Node parent = null;
        while(cur != null){
            parent = cur;
            if(cur.data > data){
                cur = cur.left;
                if(cur == null){
                    parent.left = node;
                    return true;
                }
            }else {
                cur = cur.right;
                if(cur == null){
                    parent.right = node;
                    return true;
                }

            }
        }
        return false;
    }

    public boolean delete(int data){
        Node cur = root;
        Node parent = root;
        boolean isLeftNode = false;

        //determin the delete data place
        while(cur.data != data){
            parent = cur;
            if(cur.data > data){
                isLeftNode = true;
                cur = cur.left;
            }else{
                isLeftNode = false;
                cur = cur.right;
            }
            if(cur == null){
                return false;
            }
        }
        if(cur.left == null && cur.right == null){
            if(cur == root){
                root = null;
            }else if(isLeftNode){
                parent.left = null;
            }else{
                parent.right = null;
            }
            count--;
            return true;
        }
        if(cur.left == null && cur.right != null){
            if(root == cur){
                root = root.right;
            }else if(isLeftNode){
                parent.left = cur.right;
            }else{
                parent.right = cur.right;
            }
            count--;
            return true;
        }else if(cur.left != null && cur.right == null){
            if(root == cur){
                root = cur.left;
            }else if(isLeftNode){
                parent.left = cur.left;
            }else{
                parent.right = cur.left;
            }
            count--;
            return true;
        }

        //current has the rigth Node and left node
        if(cur.left != null && cur.right != null){
            Node successorNode = getSuccessorNode(cur);
            if(root == cur){
                root = successorNode;
            }else if(isLeftNode){
                parent.left = successorNode;
            }else{
                parent.right = successorNode;
            }
            count--;
            return true;
        }
        return false;
    }

    private Node getSuccessorNode(Node node) {
        Node parent = node;
        Node successor = node;
        Node cur = node.right;
        while(cur != null){
            parent = successor;
            successor = cur;
            cur = cur.left;
        }
        parent.left = successor.right;
        successor.right = node.right;
        successor.left = node.left;
        return successor;
    }

    public int size(){
        return this.count;
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(80);
        t.insert(70);
        t.insert(100);
        t.insert(90);
        Node node = t.find(100);
        System.out.println(node.left.data);
        System.out.println(t.size());
        t.delete(80);
        Node src = t.find(100);
        Node src90 = t.find(90);
        Node src70 = t.find(70);
        System.out.println(src90.right.data);
        System.out.println(src90.left.data);
        System.out.println(t.size());
        t.posOrderRecur(t.root);

    }

}
