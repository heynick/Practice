import Struct.Trie;

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

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        String res = "";

        for (String word : words) {
            if (trie.search(word)){
                if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)){
                    res = word;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        Solution720 solution720 = new Solution720();
        String res = solution720.longestWord(words);
        System.out.println(res);
    }
}





