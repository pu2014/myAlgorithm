package com.pu.树;

import com.tools.Node;
import com.tools.Print;

/**
 * description：树的序列化与反序列化，将树结构表示为字符串的结果利于表达、比较
 *
 * @author Pubojian
 * @date 2020/2/1 18:35
 */
public class 树的序列化递归版本 {
    private static int index = -1; //反序列化
    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right.right = new Node(5);
        Print.printTree(root);

        String str = serializeOfPre(root);
        System.out.println(str);
        Node node = Deserialize(str);
        Print.printTree(node);
        String str1 = serializeOfPre(node);
        System.out.println(str1);
    }

    private static Node Deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        String[] strs = str.split("_");
        return DeserializeHelper(strs);
    }

    private static Node DeserializeHelper(String[] strs) {
        index++;
        if(!strs[index].equals("#")){
            Node node = new Node(Integer.parseInt(strs[index]));
            node.left = DeserializeHelper(strs);
            node.right = DeserializeHelper(strs);
            return node;
        }
        return null;
    }

    private static String serializeOfPre(Node root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeOfPreHelper(root, sb);
        return sb.toString();
    }

    private static void serializeOfPreHelper(Node root, StringBuilder sb) {
        if(root == null){
            sb.append("#_");
            return;
        }
        //
        sb.append(root.value + "_");
        serializeOfPreHelper(root.left, sb);
        serializeOfPreHelper(root.right, sb);
    }
}
