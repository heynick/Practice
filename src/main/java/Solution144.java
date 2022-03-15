import Struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HEYNICK
 * @Date 2022/3/14 15:56
 * @Description 二叉树的前序遍历
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode treeNode, List<Integer> res) {
         if (treeNode == null) {
             return;
         }
         res.add(treeNode.val);
         dfs(treeNode.left, res);
         dfs(treeNode.right, res);
    }

    public static void main(String[] args) {
        String root = "[1,null,2,3]";
        TreeNode treeNode = TreeNode.mkTree(root);
        Solution144 solution144 = new Solution144();
        List<Integer> res = solution144.preorderTraversal(treeNode);
        System.out.println(res);
    }
}
