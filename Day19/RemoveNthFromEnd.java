/*
Problem: Remove Nth Node From End of List
Platform: LeetCode
Topic: Linked List / Two Pointers

Approach:
Use two pointers, fast and slow. Move fast pointer n steps ahead first.
Then move both fast and slow pointers one step at a time until fast reaches the end.
The slow pointer will now be pointing to the node just before the one we need to remove.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
