/*
Problem: Meeting Rooms
Platform: LeetCode
Topic: Array / Intervals / Sorting

Approach:
Sort the intervals by their start time.
Iterate through the sorted intervals and check if the start time of the current meeting
is strictly less than the end time of the previous meeting. If so, there is an overlap.

Time Complexity: O(N log N)
Space Complexity: O(1) or O(N) depending on sorting implementation
*/

import java.util.Arrays;

class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        
        return true;
    }
}
