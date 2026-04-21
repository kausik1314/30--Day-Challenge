/*
Problem: Minimum Window Substring
Platform: LeetCode
Topic: String / Sliding Window / Hash Table

Approach:
Use a sliding window with two pointers (left and right). Expand the window by moving 'right'
until all characters of String 't' are included. Then, try to minimize the window by moving
'left' while maintaining the required characters. Keep track of the minimum window seen.

Time Complexity: O(S + T) where S and T are lengths of the strings.
Space Complexity: O(1) space since character set is fixed (ASCII array size 128).
*/

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        
        int left = 0, right = 0, minLeft = 0, minLen = Integer.MAX_VALUE;
        int required = t.length();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map[c] > 0) {
                required--;
            }
            map[c]--;
            right++;
            
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                map[leftChar]++;
                if (map[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
