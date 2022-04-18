import java.util.ArrayList;
import java.util.List;

/**
 * @Author HEYNICK
 * @Date 2022/4/18 11:03
 * @Description 字典序排序
 */
public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            ans.add(num);
            if (num * 10 <= n) {
                num = num * 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 13;
        Solution386 solution386 = new Solution386();
        List<Integer> ans = solution386.lexicalOrder(n);
        System.out.println(ans);
    }

}
