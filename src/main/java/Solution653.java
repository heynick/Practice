import Struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @Author HEYNICK
 * @Date 2022/3/21 10:20
 * @Description 两数之和Ⅳ
 */
public class Solution653 {
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> ld = new ArrayDeque<>();
        Deque<TreeNode> rd = new ArrayDeque<>();
        TreeNode temp =root;
        while (temp != null) {
            ld.addLast(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {
            rd.addLast(temp);
            temp = temp.right;
        }
        TreeNode l = ld.peekLast();
        TreeNode r = rd.peekLast();
        while (l.val < r.val) {
            int t = l.val + r.val;
            if (t == k) {
                return true;
            } else if (t < k) {
                l = getNext(ld, true);
            } else {
                r = getNext(rd, false);
            }
        }
        return false;

    }

    TreeNode getNext (Deque<TreeNode> d, boolean isLeft) {
        TreeNode cur = d.pollLast();
        TreeNode node = isLeft ? cur.right : cur.left;
        while (node != null) {
            d.addLast(node);
            node = isLeft ? node.left : node.right;
        }
        return d.peekLast();
    }

    public static void main(String[] args) {
        int k = 11;
        String str= "[5,3,6,2,4,null,7]";
        TreeNode treeNode = TreeNode.mkTree(str);
        Solution653 solution653 = new Solution653();
        Boolean res = solution653.findTarget(treeNode, k);
        System.out.println(res);
    }
}
