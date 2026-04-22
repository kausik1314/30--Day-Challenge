/*
Problem: Merge k Sorted Lists
Platform: LeetCode
Topic: Linked List / Heap (Priority Queue)

Approach:
Use a Min-Heap (Priority Queue) to keep track of the smallest node among all front nodes
of the k lists. Repeatedly pop the minimum node, add it to the merged list, and push
the next node of the popped list into the heap.

Time Complexity: O(N log k) where N is the total number of nodes, and k is the number of lists.
Space Complexity: O(k) for the priority queue.
*/

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            lists.length, (a, b) -> Integer.compare(a.val, b.val)
        );
        
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;
            
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        
        return dummy.next;
    }
}
