import java.util.ArrayList;
import java.util.List;

/**
 * @Author HEYNICK
 * @Date 2022/3/15 14:39
 * @Description  统计 按位或 能得到最大值的子集数据
 */
public class Solution2044 {

    int res = 0;

    public int countMaxOrSubsets(int[] nums) {

        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        dfs(nums, 0, 0, max);
        return res;
    }

    public void dfs(int[] nums, int i, int or, int max) {
        if(i == nums.length) {
            if (or == max) {
                res++;
            }
            return;
        }
        dfs(nums, i + 1, or | nums[i], max);
        dfs(nums, i + 1, or, max);
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5};
        Solution2044 solution2044 = new Solution2044();
        int res = solution2044.countMaxOrSubsets(nums);
        System.out.println(res);
    }
}
