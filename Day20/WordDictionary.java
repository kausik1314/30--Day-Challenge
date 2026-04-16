/*
Problem: Design Add and Search Words Data Structure
Platform: LeetCode
Topic: Trie / DFS

Approach:
Store words in a standard Trie. 
When searching, if the character is a '.', we use DFS to explore all possible children.
If it's a regular character, we traverse normally.

Time Complexity: AddWord: O(m), Search: O(m) in best case, O(26^m) worst case with dots.
Space Complexity: O(m) for depth of recursion and word storage length
*/

class WordDictionaryNode {
    WordDictionaryNode[] children = new WordDictionaryNode[26];
    boolean isWord = false;
}

class WordDictionary {
    private WordDictionaryNode root;

    public WordDictionary() {
        root = new WordDictionaryNode();
    }

    public void addWord(String word) {
        WordDictionaryNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new WordDictionaryNode();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int i, WordDictionaryNode node) {
        if (node == null) return false;
        if (i == word.length()) return node.isWord;

        char c = word.charAt(i);
        if (c == '.') {
            for (WordDictionaryNode child : node.children) {
                if (searchHelper(word, i + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            return searchHelper(word, i + 1, node.children[c - 'a']);
        }
    }
}
