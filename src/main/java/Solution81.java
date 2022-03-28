/**
 * @Author HEYNICK
 * @Date 2022/3/25 15:10
 * @Description 搜索旋转排序数组 II
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) {
            return nums[0] == target;
        }

        int left = 0, right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        int target = 0;
        Solution81 solution81 = new Solution81();
        boolean res = solution81.search(nums , target);
        System.out.println(res);
    }
}
