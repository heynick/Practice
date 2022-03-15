import Struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author HEYNICK
 * @Date 2022/2/22 15:37
 * @Description 二叉树的层序遍历
 */

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int curSize = queue.size();

            for (int i = 0; i < curSize; i++) {
                TreeNode head = queue.poll();
                curLevel.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }

            res.add(curLevel);
        }
        return res;
    }


    public static void main(String[] args) {
        String root = "[3,9,20,null,null,15,7]";
        TreeNode treeNode = TreeNode.mkTree(root);
        Solution102 solution102 = new Solution102();
        List<List<Integer>> res = solution102.levelOrder(treeNode);
        System.out.println(res);
    }

}
