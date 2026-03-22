/*
Problem: Word Search
Platform: LeetCode
Topic: Backtracking / DFS

Approach:
Iterate through the grid. If the first character matches, use DFS to search 
in 4 directions for the remaining characters. Backtrack by marking cells as visited.

Time Complexity: O(m * n * 4^L) where L is the length of the word
Space Complexity: O(L) for the recursion stack
*/

class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] b, String w, int r, int c, int idx) {
        if (idx == w.length()) return true;
        if (r < 0 || r >= b.length || c < 0 || c >= b[0].length || b[r][c] != w.charAt(idx)) {
            return false;
        }

        char temp = b[r][c];
        b[r][c] = '#';
        
        boolean found = dfs(b, w, r + 1, c, idx + 1) ||
                        dfs(b, w, r - 1, c, idx + 1) ||
                        dfs(b, w, r, c + 1, idx + 1) ||
                        dfs(b, w, r, c - 1, idx + 1);
        
        b[r][c] = temp;
        return found;
    }
}
