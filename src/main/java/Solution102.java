import java.util.ArrayList;
import java.util.List;

/**
 * @Author HEYNICK
 * @Date 2022/2/22 15:37
 * @Description 二叉树的层序遍历
 */

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        return null;
    }

    public static void main(String[] args) {
        Integer[] integers = {3,9,20,null,null,15,7};
        TreeNode node = TreeNode.makeTree(integers);
        TreeNode.middleTraverse(node);
    }

}
