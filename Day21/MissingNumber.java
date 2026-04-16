/*
Problem: Missing Number
Platform: LeetCode
Topic: Bit Manipulation / Math

Approach:
Calculate the expected sum of numbers from 0 to n using the formula n * (n + 1) / 2.
Subtract the actual sum of the numbers in the array. The difference is the missing number.
(Alternatively, XOR all indices and values together).

Time Complexity: O(n)
Space Complexity: O(1)
*/

class MissingNumber {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
}
