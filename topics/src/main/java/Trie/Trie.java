package Trie;

import java.util.List;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean eof;
}

/**
 * TimeComplexity : O(n*maxL)
 *   n = number of words
 *   maxL = max length of word
 *  Space Complexity :  O(n*maxL)
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void update(List<String> str) {
        for (String s : str) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    TrieNode temp = new TrieNode();
                    curr.children[c - 'a'] = temp;
                }
                curr = curr.children[c - 'a'];
            }
            curr.eof = true;
        }
    }

    public boolean search(String str) {
        TrieNode curr = root;
        for (char c : str.toCharArray()) {
            if (curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr.eof;
    }
}
