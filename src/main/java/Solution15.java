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
        for(int i = 0; i < len -2; i++){
            // 剪枝
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i + 1] == nums[i]){
                continue;
            }
            // 在[i + 1, len -1]区间里查找两数之和为-nums[i]
            // 因为有序，因此可以把j和k分别从区间的两端向中间靠拢
            // 因此省去一个循环
            int target = -nums[i];
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                if(nums[left] + nums[right] < target){
                    left++;
                }else if(nums[left] + nums[right] > target){
                    right--;
                }else{
                    List<Integer> cur = new ArrayList<>(3);
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);
                    // 剪枝：找到了一个解以后
                    while(left < right && nums[left] ==nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right -1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Solution15 solution15 = new Solution15();
        List<List<Integer>> res = solution15.threeSum(nums);
        System.out.println(res);
    }
}
