package org.example.Trie;

class TrieNodules {
    TrieNodules[] children = new TrieNodules[26];
    boolean wordEnd = false;
}


class WordDictionary {
    TrieNodules root;

    public WordDictionary() {
        root = new TrieNodules();
    }

    public void addWord(String word) {
        TrieNodules curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int num = ch - 'a';
            if (curr.children[num] == null) {
                curr.children[num] = new TrieNodules();
            }
            curr = curr.children[num];
        }
        curr.wordEnd = true;
    }

    public boolean search(String word, int start, TrieNodules trieNode) {
        TrieNodules curr = trieNode;
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            int num = ch - 'a';
            if (ch == '.') {
                for (TrieNodules child : curr.children) {
                    if (child != null && search(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.children[num] == null) {
                    return false;
                }
                curr = curr.children[num];
            }
        }
        return curr.wordEnd;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
}
