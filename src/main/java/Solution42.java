/**
 * @Author HEYNICK
 * @Date 2022/2/23 15:29
 * @Description 接雨水
 */
public class Solution42 {
    public int trap(int[] height){
        int len = height.length;
        // 特判
        if(len < 3){
            return 0;
        }
        int res = 0;
        for(int i = 1; i < len -1; i++){
            int leftMax = leftMax(i, height);
            int rightMax = rightMax(i, height, len);
            // 核心逻辑
            if(height[i] < Math.min(leftMax, rightMax)){
                res += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return res;
    }

    private int leftMax(int center, int[] height){
        int res = 0;
        for(int i = center -1; i >= 0; i--){
            res = Math.max(res, height[i]);
        }
        return res;
    }

    private int rightMax(int center, int[] height, int n){
        int res = 0;
        for(int i = center + 1; i < n; i++){
            res = Math.max(res, height[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution42 solution42 = new Solution42();
        int res = solution42.trap(height);
        System.out.println(res);
    }
}
