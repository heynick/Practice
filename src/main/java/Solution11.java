/**
 * @Author HEYNICK
 * @Date 2022/2/16 23:07
 * @Description 盛最多水的容器
 */
public class Solution11 {

    public int maxArea(int[] height){
        int len = height.length;
        int res = 0;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                //长取height[i]和height[j]中的最小值，宽为j-i
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }

    public int pointerMaxArea(int[] height){
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int res = 0;
        while(left <= right){
            res = Math.max(res, Math.min(height[right], height[left]) * (right - left));
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        Solution11 solution11 = new Solution11();
        // 暴力解法
        int res = solution11.maxArea(height);
        System.out.println(res);
        // 双指针
        int pointerRes = solution11.pointerMaxArea(height);
        System.out.println(pointerRes);
    }
}
