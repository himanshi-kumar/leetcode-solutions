/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //dummy->1->2->3->4
        //Node 1 Node 2
        //Node 2 Node 1
        //prev->first->second->nextpair
        //prev->second->first->nextPair
        //1->2
        //first.next = second.next
        //second.next = first
        //prev.next =second
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next!=null && prev.next.next!=null){
            ListNode first = prev.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;

        }
        
        return dummy.next;
    }
}