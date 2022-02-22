import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/2/17 15:47
 * @Description 合并两个有序数组
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        //new一个数组用于归并
        int len = m + n;
        int[] temp = new int[len];
        System.arraycopy(nums1, 0, temp, 0, len);

        int i = 0;
        int j = 0;
        for (int k = 0; k < len; k++){
            //边界
            if (i == m){
                nums1[k] = nums2[j];
                j++;
            }else if (j == n){
                nums1[k] = temp[i];
                i++;
            }else if (temp[i] <= nums2[j]){
                nums1[k] = temp[i];
                i++;
            }else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }

    /**
     * Arrays类的sort方法
     */
    public void mergeEasy(int[] nums1, int m, int[] nums2, int n){
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args){
        System.out.println("归并");
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        Solution88 solution88 = new Solution88();
        solution88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        System.out.println("Arrays.sort");
        int[] nums3 = {1,2,3,0,0,0};
        solution88.mergeEasy(nums3, m, nums2, n);
        System.out.println(Arrays.toString(nums3));
    }
}
