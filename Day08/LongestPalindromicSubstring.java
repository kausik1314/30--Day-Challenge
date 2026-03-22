/*
Problem: Longest Palindromic Substring
Platform: LeetCode
Topic: String / Dynamic Programming

Approach:
For each character (and character pair), expand outwards to find the longest palindrome.
Keep track of the maximum length and starting index.

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

class LongestPalindromicSubstring {
    int start = 0, maxLen = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);     // Odd length
            expand(s, i, i + 1); // Even length
        }

        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (maxLen < r - l - 1) {
            start = l + 1;
            maxLen = r - l - 1;
        }
    }
}
