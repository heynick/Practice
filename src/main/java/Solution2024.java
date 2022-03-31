/**
 * @Author HEYNICK
 * @Date 2022/3/29 11:46
 * @Description 考试的最大困扰度
 */
public class Solution2024 {
    String s;
    int n, k;
    public int maxConsecutiveAnswers(String answerKey, int _k) {
        s = answerKey;
        n = s.length(); k = _k;
        return Math.max(getCnt('T'), getCnt('F'));
    }
    int getCnt(char c) {
        int ans = 0;
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == c) cnt++;
            while (cnt > k) {
                if (s.charAt(j) == c) cnt--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        String answerKey = "TTFTTFTT";
        int k = 1;
        Solution2024 solution2024 = new Solution2024();
        int res = solution2024.maxConsecutiveAnswers(answerKey, k);
        System.out.println(res);
    }

}
