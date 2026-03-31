/*
Problem: Kth Largest Element in an Array
Platform: LeetCode
Topic: Heap / Priority Queue

Approach:
Use a Min-Heap of size K. Iterate over the array, adding elements to the heap.
If the heap size exceeds K, poll (remove) the smallest element.
The root of the heap will be the Kth largest element.

Time Complexity: O(n log k)
Space Complexity: O(k)
*/

import java.util.PriorityQueue;

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
