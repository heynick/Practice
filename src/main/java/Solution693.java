/**
 * @Author HEYNICK
 * @Date 2022/3/28 10:55
 * @Description default
 */
public class Solution693 {
    public boolean hasAlternatingBits(int n) {
        int remainder = 0, lastRemainder = n % 2;
        String res = Integer.toString(lastRemainder);
        n /= 2;
        while (n != 0) {
            remainder = n % 2;
            if (remainder == lastRemainder) {
                return false;
            }
            res = remainder + res;
            lastRemainder = remainder;
            n /= 2;
        }
        System.out.println(res);
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        Solution693 solution693 = new Solution693();
        boolean res = solution693.hasAlternatingBits(n);
        System.out.println(res);
    }
}
