/*
Problem: House Robber
Platform: LeetCode
Topic: Dynamic Programming

Approach:
For each house, we can either rob it (current house + max money from 2 houses ago) 
or skip it (max money from 1 house ago).
Keep track of previous two states.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int rob1 = 0; // max money if we rob up to i-2
        int rob2 = 0; // max money if we rob up to i-1
        
        for (int n : nums) {
            int temp = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }
}
