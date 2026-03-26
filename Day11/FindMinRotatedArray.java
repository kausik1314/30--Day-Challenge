/*
Problem: Find Minimum in Rotated Sorted Array
Platform: LeetCode
Topic: Binary Search

Approach:
If the middle element is greater than the rightmost element, the minimum must be 
to its right. Otherwise, the minimum is the middle element or to its left.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class FindMinRotatedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        
        return nums[l];
    }
}
