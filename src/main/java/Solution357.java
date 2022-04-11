import java.util.ArrayList;
import java.util.List;

/**
 * @Author HEYNICK
 * @Date 2022/4/11 14:56
 * @Description 统计各位数字都不同的数字个数
 */
public class Solution357 {
    /**
     * f[l][r] 代表 i * (i + 1) * ... * (j - 1) * j
     */
    static int[][] f = new int[10][10];

    static {
        for (int i = 1; i <= 9; i++) {
            for (int j = i; j <= 9; j++) {
                int cur = 1;
                for (int k = i; k <= j; k++) cur *= k;
                f[i][j] = cur;
            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        Solution357 solution357 = new Solution357();
        int res = solution357.countNumbersWithUniqueDigits(n);
        System.out.println(res);
    }

    public int countNumbersWithUniqueDigits(int n) {
        System.out.println(f[5][6]);
        System.out.println(1 << 3);
        return n == 0 ? 1 : dp((int) Math.pow(10, n) - 1);
    }

    int dp(int x) {
        int t = x;
        List<Integer> nums = new ArrayList<>();
        while (t != 0) {
            nums.add(t % 10);
            t /= 10;
        }
        int n = nums.size();
        if (n <= 1) return x + 1; // [0,9]
        // 位数和x相同，但最高位比x最高位要小的
        int res1 = nums.get(n - 1) - 1;
        for (int i = 1; i < n; i++) res1 *= (10 - i);
        // 位数和x相同，但最高位与x最高位相同的
        int res2 = 0;
        for (int i = n - 2, s = (1 << (nums.get(n - 1))), p = 2; i >= 0; i--, p++) {
            int cur = nums.get(i), cnt = 0;
            for (int j = cur - 1; j >= 0; j--) {
                if (((s >> j) & 1) == 0) cnt++;
            }
            int a = 10 - p, b = a - (n - p) + 1;
            res2 += b < a ? f[b][a] * cnt : cnt;
            if (((s >> cur) & 1) == 1) {
                break;
            } else {
                s |= (1 << cur);
                if (i == 0) res2++;
            }
        }
        // 位数比x少
        int res3 = 10;
        for (int i = 2, last = 9; i < n; i++) {
            int cur = last * (10 - i + 1);
            res3 += cur;
            last = cur;
        }
        return res1 + res2 + res3;
    }
}
