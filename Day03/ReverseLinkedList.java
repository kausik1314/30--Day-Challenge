/*
Problem: Reverse Linked List
Platform: LeetCode
Topic: Linked List

Approach:
Iterate keeping track of prev, curr, and next nodes.
Reverse the pointers step by step.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode() {}
}

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        
        return prev;
    }
}
