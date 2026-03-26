/*
Problem: Course Schedule II
Platform: LeetCode
Topic: Graphs / Topological Sort

Approach:
Use Kahn's algorithm (BFS) for Topological Sorting. Track the in-degrees of nodes.
Nodes with 0 in-degree are processed and added to the result sequence.

Time Complexity: O(V + E)
Space Complexity: O(V + E)
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        int[] inDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }
        
        int[] order = new int[numCourses];
        int idx = 0;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            order[idx++] = curr;
            
            for (int next : adj.get(curr)) {
                if (--inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        return idx == numCourses ? order : new int[0];
    }
}
