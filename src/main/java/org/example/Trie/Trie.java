package org.example.Trie;

public class Trie {
    static class TrieNode {
        TrieNode[] booleanAlphabets = new TrieNode[26];
        boolean isEnd = false;
    }

    static class PrefixTree {
        TrieNode root;

        public PrefixTree() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int i = ch - 'a';
                if (curr.booleanAlphabets[i] == null) {
                    curr.booleanAlphabets[i] = new TrieNode();
                }
                curr = curr.booleanAlphabets[i];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (cur.booleanAlphabets[i] == null) {
                    return false;
                }
                cur = cur.booleanAlphabets[i];
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (cur.booleanAlphabets[i] == null) {
                    return false;
                }
                cur = cur.booleanAlphabets[i];
            }
            return true;
        }
    }
}
