/*
Problem: Top K Frequent Elements
Platform: LeetCode
Topic: Hash Map / Priority Queue (Heap)

Approach:
Count the frequencies of each element using a HashMap.
Then use a Min-Heap (Priority Queue) to keep track of the top K frequent elements.
If heap size exceeds K, we remove the element with the smallest frequency.

Time Complexity: O(N log K)
Space Complexity: O(N)
*/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2)
        );
        
        for (int num : count.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll();
        }
        
        return res;
    }
}
