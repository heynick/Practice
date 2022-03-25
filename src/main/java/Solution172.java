/**
 * @Author HEYNICK
 * @Date 2022/3/25 10:29
 * @Description 阶乘后的零
 */
public class Solution172 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        int n = 5;
        Solution172 solution172 = new Solution172();
        int res = solution172.trailingZeroes(n);
        System.out.println(res);

    }
}
