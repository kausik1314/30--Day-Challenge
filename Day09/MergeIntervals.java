/*
Problem: Merge Intervals
Platform: LeetCode
Topic: Arrays / Sorting

Approach:
Sort intervals by their start time. Iterate through the sorted intervals.
If the current interval overlaps with the last merged interval, merge them by updating the end time.

Time Complexity: O(n log n)
Space Complexity: O(n) for the result list structure
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        
        int[] current = intervals[0];
        merged.add(current);
        
        for (int[] interval : intervals) {
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                merged.add(current);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}
