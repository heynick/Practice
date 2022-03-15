import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author HEYNICK
 * @Date 2022/3/14 16:58
 * @Description 全排列
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // path 记录从根结点到任意结点的路径
        Deque<Integer> path = new ArrayDeque<>(len);
        // used 记录某个下标元素是否使用过
        boolean[] used = new boolean[len];
        // index 表示当前需要确定的下标位置, 初始化为0
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int index, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        // 递归终止条件
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 数被使用时跳过
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            System.out.println("path => " + path);
            used[i] = true;
            // 下一层
            dfs(nums, len, index + 1, path, used, res);
            //状态重置
            path.removeLast();
            System.out.println("path => " + path);
            used[i] = false;
            }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution46 solution46 = new Solution46();
        List<List<Integer>> res = solution46.permute(nums);
        System.out.println(res);

    }
}
