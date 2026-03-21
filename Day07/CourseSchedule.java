/*
Problem: Course Schedule
Platform: LeetCode
Topic: Graphs / Topological Sort

Approach:
Use Kahn's algorithm (BFS for Topological Sort). Calculate in-degrees of all courses.
Push courses with 0 in-degree to a queue. Process them, decrement in-degree of neighbors,
and if a neighbor's in-degree becomes 0, push to queue. Check if all courses are visited.

Time Complexity: O(V + E)
Space Complexity: O(V + E)
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int next : adj.get(curr)) {
                if (--inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        return count == numCourses;
    }
}
