/*
Problem: Maximum Subarray
Platform: LeetCode
Topic: Array / Dynamic Programming

Approach:
Kadane's Algorithm. Keep track of the current sum. If it dips below 0, reset it to 0. 
Keep track of max sum seen.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        
        for (int n : nums) {
            sum += n;
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        
        return max;
    }
}
