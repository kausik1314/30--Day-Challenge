/*
Problem: Contains Duplicate
Platform: LeetCode
Topic: Hashing

Approach:
Use a HashSet to keep track of the elements we have seen so far.
If we encounter an element already in the set, it means a duplicate exists.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();
        int[] nums = { 1, 2, 3, 1 };
        boolean result = solution.containsDuplicate(nums);
        System.out.println("Contains Duplicate: " + result);
    }
}
