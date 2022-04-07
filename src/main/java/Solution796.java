/**
 * @Author HEYNICK
 * @Date 2022/4/7 15:28
 * @Description 旋转字符串
 */
public class Solution796 {
    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        Solution796 solution796 = new Solution796();
        boolean ans = solution796.rotateString(s, goal);
        System.out.println(ans);
    }

    public boolean rotateString(String s, String goal) {
        int len = s.length();
        for (int i = 1; i < len; i++) {
            String str1 = s.substring(0, i);
            String str2 = goal.substring(len - i, len);
            String str3 = s.substring(i, len);
            String str4 = goal.substring(0, len - i);
            if (str1.equals(str2) && str3.equals(str4)) {
                return true;
            }
        }
        return false;
    }
}
