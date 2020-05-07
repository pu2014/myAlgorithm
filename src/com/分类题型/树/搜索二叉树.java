package com.分类题型.树;

public class 搜索二叉树 {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(4);
        bst.insert(7);
        bst.insert(6);
        bst.insert(2);
        bst.print(bst.root);
        bst.show(bst.find(4));
        System.out.println(bst.delete(3));
        bst.print(bst.root);

    }
}

class BinarySearchTree{
    public Node root;
    class Node{
        int data;
        Node right;
        Node left;
        int size;
        Node(int data) {
            this.data = data;
            this.size = 0;
        }
    }

    public void insert(int key){
        Node node = new Node(key);

        if(root == null){
            root = node;
            root.size++;
        }else{
            Node parent;
            Node cur = root;
            while(true){
                parent = cur;
                if(key > cur.data){
                    cur = cur.right;
                    if(cur == null){
                        parent.right = node;
                        node.size++;
                        return;
                    }
                }else if(key < cur.data){
                    cur = cur.left;
                    if(cur == null){
                        parent.left = node;
                        node.size++;
                        return;
                    }
                }else{
                    cur.size++;
                    return;
                }
            }
        }
    }
    public Node find(int key){
        Node cur = root;
        if(cur == null){
            return null;
        }
        while(cur.data != key){
            if(cur.data > key){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
            if(cur == null){
                return null;
            }
        }
        return cur;
    }
    public void print(Node node){
        process(node);
        System.out.println();
    }

    private void process(Node node) {
        if(node == null){
            return;
        }
        System.out.print(node.data + "<" + node.size +">  ");
        process(node.left);
        process(node.right);
    }

    public void show(Node node){
        if(node == null){
            return;
        }else{
            System.out.println(node.data + "<" + node.size +">");
        }

    }

    public boolean delete(int key){
        boolean result = false;
        Node cur = root;
        Node parent = null;
        boolean isRight = false;
        while(cur.data != key){
            parent = cur;
            if(cur.data < key){
                cur = cur.right;
                isRight = true;
            }else{
                cur = cur.left;
                isRight = false;
            }
            if(cur == null)
                break;
        }

        if(cur.size > 1){
            cur.size--;
            result = true;
        }else {
            if (cur.right == null && cur.left == null) {
                if (cur == root) {
                    root = null;
                } else {
                    if (isRight) {
                        parent.right = null;
                    } else{
                    parent.left = null;
                    }
                }
            } else if (cur.left == null) {
                if(cur == root){
                    root = cur.right;
                } else if(isRight){
                    parent.right = cur.right;
                } else{
                    parent.left = cur.right;
                }
            } else if(cur.right == null){
                if(cur == root){
                    root = cur.left;
                } else if(isRight){
                    parent.right = cur.left;
                } else{
                    parent.left = cur.left;
                }
            } else{
                Node suc = getSucessor(cur);
                if(cur == root){
                    root = cur;
                }else if(isRight){
                    parent.right = suc;
                }else{
                    parent.left = suc;
                    suc.left = cur.left;
                }
            }
            result = true;
        }
        return result;
    }

    private Node getSucessor(Node delNode) {
        Node sucParent = delNode;
        Node suc = delNode;
        Node cur = delNode.right;
        while(cur != null){
            sucParent = suc;
            suc = cur;
            cur = cur.left;
        }
     //adjust
        if(suc != delNode.right){
            sucParent.left = suc.right;
            suc.right = delNode.right;
        }
        return suc;
    }
}

