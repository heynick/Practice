/**
 * @Author HEYNICK
 * @Date 2022/3/15 17:32
 * @Description 搜索插入位置
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            //int mid = (left + right) >> 1;
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        Solution35 solution35 = new Solution35();
        int res = solution35.searchInsert(nums, target);
        System.out.println(res);
    }
}
