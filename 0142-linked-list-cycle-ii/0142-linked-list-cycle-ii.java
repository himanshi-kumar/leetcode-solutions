public class Solution {
    public ListNode detectCycle(ListNode head) {

        // Phase 1: Detect cycle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Phase 2: Find cycle starting node
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        // No cycle
        return null;
    }
}