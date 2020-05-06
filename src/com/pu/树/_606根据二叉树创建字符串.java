package com.pu.树;

import com.tools.TreeNode;

import java.util.Stack;

/**
 * @DESC
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 *
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @CREATE BY @Author pbj on @Date 2020/5/6 11:37
 */
public class _606根据二叉树创建字符串 {
    public static void main(String[] args) {
        Tree2str tree2str = new Tree2str();

        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);

        System.out.println(tree2str.method(t));
    }
}
class Tree2str {
    public String method(TreeNode t) {
        if(t == null){
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(t.val));
        if(t.left == null && t.right == null) {
            return sb.toString();
        }
        if(t.left == null){
            sb.append('(').append(')');
        }else{
            sb.append('(').append(method(t.left)).append(')');
        }
        if(t.right == null){
            return sb.toString();
        }else{
            sb.append('(').append(method(t.right)).append(')');
        }
        return sb.toString();
    }
}

