import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/3/14 20:22
 * @Description default
 */
public class Solution509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 0;
        dp[1] = 1;
        // 递归
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
         }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        Solution509 solution509 = new Solution509();
        int res = solution509.fib(n);
        System.out.println(res);
    }
}
