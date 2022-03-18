import Struct.Trie;

import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/3/18 11:17
 * @Description 实现前缀树
 */
public class Solution208 {



    public static void main(String[] args) {
        String word = "word";
        String prefix = "w";
        Trie trie = new Trie();
        trie.insert(word);
        boolean param_2 = trie.search(word);
        boolean param_3 = trie.startsWith(prefix);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(trie.toSring());

    }
}
