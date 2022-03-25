/**
 * @Author HEYNICK
 * @Date 2022/3/25 10:37
 * @Description 搜索旋转排序数组
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int pivot = searchPovot(nums, 0, len - 1);
        int left1 = searchNew(nums, target, 0,pivot - 1);
        int left2 = searchNew(nums, target, pivot, len - 1);
        if (nums[left1] == target) {
            return left1;
        } else if (nums[left2] == target) {
            return left2;
        } else {
            return -1;
        }
    }

    private int searchPovot(int []nums, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int searchNew(int []nums, int target, int left, int right) {
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
        int[] nums = {2,3,4,5,6,7,8,9,1};
        int target = 9;
        Solution33 solution33 = new Solution33();
        int res = solution33.search(nums, target);
        System.out.println(res);
    }
}
