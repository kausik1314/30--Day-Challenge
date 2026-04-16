/*
Problem: Number of 1 Bits
Platform: LeetCode
Topic: Bit Manipulation

Approach:
Bitwise AND the number with (number - 1). This operation inherently drops the lowest set bit.
Count how many times this operation is performed until the number becomes zero.

Time Complexity: O(1) worst-case 32 operations
Space Complexity: O(1)
*/

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
