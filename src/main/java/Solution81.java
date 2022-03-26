/**
 * @Author HEYNICK
 * @Date 2022/3/25 15:10
 * @Description 搜索旋转排序数组 II
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        Solution81 solution81 = new Solution81();
        boolean res = solution81.search(nums , target);
        System.out.println(res);
    }
}
