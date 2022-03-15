import Struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author HEYNICK
 * @Date 2022/3/14 16:28
 * @Description 二叉树的后序遍历
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, res);
        dfs(treeNode.right, res);
        res.add(treeNode.val);
    }

    public static void main(String[] args) {
        String str = "[1,null,2,3]";
        TreeNode treeNode = TreeNode.mkTree(str);
        Solution145 solution145 = new Solution145();
        List<Integer> res = solution145.postorderTraversal(treeNode);
        System.out.println(res);
    }
}
