import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/4/12 21:27
 * @Description 写字符串需要的行数
 */
public class Solution806 {
    public int[] numberOfLines(int[] widths, String s) {
        int a = 0, b = 0;
        for (char c : s.toCharArray()) {
            int t = widths[c - 'a'];
            if (b + t > 100 && ++a>= 0) {
                b = t;
            } else {
                b += t;
            }
        }
        if (b != 0) {
            a++;
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        Solution806 solution806 = new Solution806();
        int[] ans = solution806.numberOfLines(widths, s);
        System.out.println(Arrays.toString(ans));
    }
}
