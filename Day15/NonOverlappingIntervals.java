/*
Problem: Non-overlapping Intervals
Platform: LeetCode
Topic: Greedy / Intervals

Approach:
Sort the intervals by their end times. Keep track of the end time of the last added interval.
If the next interval's start time is less than the current end time, it overlaps, so we must remove it.
Otherwise, we update the current end time to the next interval's end time.

Time Complexity: O(n log n)
Space Complexity: O(1) or O(n) depending on sorting implementation
*/

import java.util.Arrays;

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
