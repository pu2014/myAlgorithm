package com.pu.树;

import com.tools.Print;
import com.tools.TreeNode;

/**
 * @DESC
 *我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * @CREATE BY @Author pbj on @Date 2020/5/5 10:02
 */
public class _1028从先序遍历还原二叉树 {
    public static void main(String[] args) {
        RecoverFromPreorder proc = new RecoverFromPreorder();
        Print.printTree(proc.method("1-2--3--4-5--6--7"));
        Print.printTree(proc.method("1-401--349---90--88"));
    }
}
class RecoverFromPreorder {
    public TreeNode method(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        TreeNode[] node = new TreeNode[S.length()];
        int i = 0;
        while(i < S.length()){
            int count = 0;
            while(i < S.length() - 1 && S.charAt(i) == '-'){
                i++;
                count++;
            }
            String num = "";
            while(i < S.length() && S.charAt(i) != '-'){
                num += S.charAt(i);
                i++;
            }
            TreeNode cur = new TreeNode(Integer.parseInt(num));
            if(count == 0){
                node[count] = cur;
                continue;
            }
            int k = count;
            if(node[count] != null){
                node[count - 1].right = cur;
                node[count] = cur;
            }else{
                node[count - 1].left = cur;
                node[count] = cur;
            }
            for(int n = k + 1; n < node.length; n++){
                node[n] = null;
            }
        }
        return node[0];
    }
}
