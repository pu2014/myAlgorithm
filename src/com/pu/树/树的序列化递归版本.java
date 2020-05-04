package com.pu.树;

import com.tools.TreeNode;
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
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        Print.printTree(root);

        String str = serializeOfPre(root);
        System.out.println(str);
        TreeNode node = Deserialize(str);
        Print.printTree(node);
        String str1 = serializeOfPre(node);
        System.out.println(str1);
    }

    private static TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0){
            return null;
        }
        String[] strs = str.split("_");
        return DeserializeHelper(strs);
    }

    private static TreeNode DeserializeHelper(String[] strs) {
        index++;
        if(!strs[index].equals("#")){
            TreeNode node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = DeserializeHelper(strs);
            node.right = DeserializeHelper(strs);
            return node;
        }
        return null;
    }

    private static String serializeOfPre(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeOfPreHelper(root, sb);
        return sb.toString();
    }

    private static void serializeOfPreHelper(TreeNode root, StringBuilder sb) {
        if(root == null){
            sb.append("#_");
            return;
        }
        //
        sb.append(root.val + "_");
        serializeOfPreHelper(root.left, sb);
        serializeOfPreHelper(root.right, sb);
    }
}
