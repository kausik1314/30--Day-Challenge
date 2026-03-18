/*
Problem: Two Sum II - Input Array Is Sorted
Platform: LeetCode
Topic: Two Pointers

Approach:
Use left and right pointers. Move left up if the sum is too small, move right down if it's too large.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l + 1, r + 1};
            if (sum < target) l++;
            else r--;
        }
        
        return new int[]{};
    }
}
