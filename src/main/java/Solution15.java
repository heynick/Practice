import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author HEYNICK
 * @Date 2022/2/23 10:24
 * @Description 三数之和
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len < 3){
            return res;

        }
        // 预处理
        Arrays.sort(nums);
        System.out.println(nums.toString());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Solution15 solution15 = new Solution15();
        solution15.threeSum(nums);
    }
}
