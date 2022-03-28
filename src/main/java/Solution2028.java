import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/3/27 23:32
 * @Description 找出缺失的观测数据
 */
public class Solution2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, cnt = m + n;
        int t = mean * cnt;
        for (int i : rolls) {
            t -= i;
        }
        if (t < n || t > 6 * n) {
            return new int[0];
        }

        int[] ans = new int[n];
        Arrays.fill(ans, t / n);
        int d = t - (t / n * n), idx = 0;

        while (d --> 0) {
            ans[idx++]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] rolls = {1,5,6};
        int mean = 3;
        int n = 4;
        Solution2028 solution2028 = new Solution2028();
        int[] res = solution2028.missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(res));
    }
}
