import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author HEYNICK
 * @Date 2022/3/17 19:23
 * @Description 词典中最长的单词
 */
public class Solution720 {
    public String longestWord(String[] words) {

        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        String ans = "";

        out:
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                if (!set.contains(word.substring(0, i))) {
                    continue  out;
                }
            }

            if (word.length() > ans.length()) {
                ans = word;
            } else if (word.length() == ans.length()) {
                if (word.compareTo(ans) < 0) {
                    ans = word;
                }
            }



        }

        Arrays.sort(words, (a, b) -> {
            return 0;
        });






        return ans;
    }


    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        Solution720 solution720 = new Solution720();
        String res = solution720.longestWord(words);
        System.out.println(res);
    }


    }
