/*
Problem: Reverse Bits
Platform: LeetCode
Topic: Bit Manipulation

Approach:
Iterate 32 times. In each iteration, extract the rightmost bit of 'n' using (n & 1).
Shift the accumulated result 'res' to the left by 1 and use bitwise OR to append the extracted bit.
Shift 'n' to the right by 1 to process the next bit.

Time Complexity: O(1) 
Space Complexity: O(1)
*/

public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }
        return res;
    }
}
