import Struct.TreeNode;

import java.util.ArrayList;

/**
 * @Author HEYNICK
 * @Date 2022/3/21 15:26
 * @Description 根据二叉树创建字符串
 */
public class Solution606 {
    public String tree2str(TreeNode root) {
        if (root == null) {
             return "";
        }
        if (root.left == null && root.right == null) {
            return root.val + "";
        }
        String leftStr = tree2str(root.left);
        String rightStr = tree2str(root.right);
        if (root.left != null && root.right == null) {
            return root.val + "(" + leftStr + ")";
        }
        if (root.left == null && root.right != null) {
            return root.val + "()" + "(" + rightStr + ")";
        }
        return  root.val + "(" + leftStr + ")" + "(" + rightStr + ")";
    }

    public static void main(String[] args) {
        String str = "[1,2,3,4]";
        TreeNode treeNode = TreeNode.mkTree(str);
        Solution606 solution606 = new Solution606();
        String res = solution606.tree2str(treeNode);
        System.out.println(res);
    }




}
