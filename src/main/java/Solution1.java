import java.util.Arrays;

/**
 * @Author
 * @Date 2022/2/16 23:07
 * @Description 两数之和
 */
public class Solution1{
    public int[] twoSum(int[] nums, int target){
        int len = nums.length;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                if (nums[i] + nums[j] ==target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution1 solution1 = new Solution1();
        int[] res = solution1.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
