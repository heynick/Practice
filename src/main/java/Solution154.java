import org.apache.arrow.flatbuf.Int;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author HEYNICK
 * @Date 2022/3/24 20:19
 * @Description 寻找旋转排序数组中的最小值 II
 */
public class Solution154 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        Solution154 solution154 = new Solution154();
        int res = solution154.findMin(nums);
        System.out.println(res);

    }
}
