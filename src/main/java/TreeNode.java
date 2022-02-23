/**
 * @author HEYNICK
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    private TreeNode(int x) { val = x; }

    public static TreeNode makeTree(Integer[] trees) {
        TreeNode[] treeNodes = new TreeNode[trees.length + 1];
        for (int i = 1; i < treeNodes.length; i++) {
            if (trees[i - 1] == null) {
                treeNodes[i] = null;
            } else {
                treeNodes[i] = new TreeNode(trees[i - 1]);
            }
        }

        TreeNode treeNode = null;
        for (int i = 1; i <= treeNodes.length / 2; i++) {
            treeNode = treeNodes[i];
            if (treeNode == null) {
                continue;
            }
            treeNode.left = treeNodes[2 * i];
            if (2 * i + 1 < treeNodes.length) {
                treeNode.right = treeNodes[2 * i + 1];
            }
        }
        return treeNodes[1];
    }

    //中序遍历，检查树的创建是否正确
    public static void middleTraverse(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            middleTraverse(treeNode.left);
            middleTraverse(treeNode.right);
        } else {
            System.out.println("null");
        }
    }
}