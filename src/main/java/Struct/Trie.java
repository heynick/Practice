package Struct;

import java.util.Arrays;

/**
 * @Author HEYNICK
 * @Date 2022/3/18 11:17
 * @Description 前缀树
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = seachPrefix(word);
        return node != null && node.isEnd;

    }

    public boolean startsWith(String prefix) {
        return seachPrefix(prefix) != null;

    }

    private Trie seachPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null || !node.children[index].isEnd) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }


    public String toSring() {
        return Arrays.toString(children);
    }

}
