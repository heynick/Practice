/**
 * @Author HEYNICK
 * @Date 2022/3/22 9:41
 * @Description 如果相邻两个颜色均相同则删除当前颜色
 */
public class Solution2038 {
    public boolean winnerOfGame(String colors) {
        char[] cs = colors.toCharArray();
        int n = cs.length;
        int a = 0, b = 0;
        for (int i = 1; i < n - 1; i++) {
            if (cs[i] == 'A' && cs[i - 1] == 'A' && cs[i + 1] == 'A') {
                a++;
            }
            if (cs[i] == 'B' && cs[i - 1] == 'B' && cs[i + 1] == 'B') {
                b++;
            }
        }
        return a > b;

    }

    public static void main(String[] args) {
        String s = "AAABABB";
        Solution2038 solution2038 = new Solution2038();
        boolean res = solution2038.winnerOfGame(s);
        System.out.println(res);
    }
}
