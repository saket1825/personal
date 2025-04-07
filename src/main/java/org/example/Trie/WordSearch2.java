package org.example.Trie;

import java.util.ArrayList;
import java.util.List;


class TrieNodule {
    TrieNodule[] children = new TrieNodule[26];
    int idx = -1;
    int refs = 0;

    public void insertInTrie(String word, int i) {
        TrieNodule curr = this;
        curr.refs++;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNodule();
            }
            curr = curr.children[index];
            curr.refs++;
        }
        curr.idx = i;
    }
}

public class WordSearch2 {
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNodule root = new TrieNodule();
        for (int i = 0; i < words.length; i++) {
            root.insertInTrie(words[i], i);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, root, r, c, words);
            }
        }

        return res;
    }

    private void dfs(char[][] board, TrieNodule curr, int r, int c, String[] words) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#' || curr.children[board[r][c] - 'a'] == null) {
            return;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        TrieNodule prev = curr;
        curr = curr.children[temp - 'a'];
        if (curr.idx != -1) {
            res.add(words[curr.idx]);
            curr.idx = -1;
            curr.refs--;
             if(curr.refs == 0){
                 curr = null;
                 prev.children[temp-'a'] = null;
                 board[r][c] = temp;
             return;
             }
        }
        dfs(board, curr, r + 1, c, words);
        dfs(board, curr, r - 1, c, words);
        dfs(board, curr, r, c + 1, words);
        dfs(board, curr, r, c - 1, words);

        board[r][c] = temp;
    }
}

