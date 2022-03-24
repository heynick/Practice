/**
 * @Author HEYNICK
 * @Date 2022/3/24 19:42
 * @Description 寻找旋转排序数组中的最小值
 */
public class Solution153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
        }
        return nums[left];

    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        Solution153 solution153 = new Solution153();
        int res = solution153.findMin(nums);
        System.out.println(res);
    }
}
