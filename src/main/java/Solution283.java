import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/2/17 10:59
 * @Description 移动零
 */
public class Solution283 {

    public void moveZeroes(int[] nums){
        //循环不变量 nums[0..j) !=0, nums[j..i) = 0
        //语言描述 非零元素的相对顺序不变
        //初始时
        //循环过程中
        //结束时
        int j = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < len; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Solution283 solution283 = new Solution283();
        solution283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
