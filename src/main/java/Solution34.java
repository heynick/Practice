import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/3/24 15:44
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {

        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int begin = searchFirstPosition(nums, target);
        if (begin == -1) {
            return new int[]{-1, -1};
        }

        int end = searchLastPosition(nums, target);
        return new int[]{begin,end};
    }

    private int searchFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int searchLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        Solution34 solution34 =new Solution34();
        int[] res = solution34.searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
