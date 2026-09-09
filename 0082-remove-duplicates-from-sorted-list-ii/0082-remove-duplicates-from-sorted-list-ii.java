class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {

            // Check if current is a duplicate
            if (current.next != null && current.val == current.next.val) {

                int duplicate = current.val;

                // Skip all nodes having the duplicate value
                while (current != null && current.val == duplicate) {
                    current = current.next;
                }

                // Remove all duplicates
                prev.next = current;

            } else {

                // Current is not duplicate
                prev = current;
                current = current.next;
            }
        }

        return dummy.next;
    }
}