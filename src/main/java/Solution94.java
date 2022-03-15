import Struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HEYNICK
 * @Date 2022/3/14 16:18
 * @Description 二叉树的中序遍历
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, res);
        res.add(treeNode.val);
        dfs(treeNode.right, res);

    }

    public static void main(String[] args) {
        String str = "[1,null,2,3]";
        TreeNode treeNode = TreeNode.mkTree(str);
        Solution94 solution94 = new Solution94();
        List<Integer> res = solution94.inorderTraversal(treeNode);
        System.out.println(res);
    }

}
