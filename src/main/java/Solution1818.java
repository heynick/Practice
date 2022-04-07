import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/4/7 16:51
 * @Description 绝对差值和
 */
public class Solution1818 {
    int mod = (int) 1e9 + 7;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        long sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            if (a == b) continue;
            int x = Math.abs(a - b);
            sum += x;
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + right + 1 >> 1;
                if (sorted[mid] <= b) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            int nd = Math.abs(sorted[left] - b);
            if (left + 1 < n) {
                nd = Math.min(nd, Math.abs(sorted[left + 1] - b));
            }

            if (nd < x) {
                max = Math.max(max, x - nd);
            }
        }
        return (int) ((sum - max) % mod);
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 7, 5}, nums2 = {2, 3, 5};
        Solution1818 solution1818 = new Solution1818();
        int ans = solution1818.minAbsoluteSumDiff(nums1, nums2);
        System.out.println(ans);
    }

}


