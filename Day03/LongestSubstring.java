/*
Problem: Longest Substring Without Repeating Characters
Platform: LeetCode
Topic: Sliding Window

Approach:
Use a set to keep track of characters in current window [l, r].
If duplicate found, shrink window from left.

Time Complexity: O(n)
Space Complexity: O(min(m, n))
*/

import java.util.HashSet;

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0, maxLen = 0;
        
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }
        
        return maxLen;
    }
}
