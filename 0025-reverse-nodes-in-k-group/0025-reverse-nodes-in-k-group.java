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
    public ListNode reverseKGroup(ListNode head, int k) {
        // check if we have k nodes ahead
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head; // not enough nodes
            node = node.next;
        }

        // reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // connect with the rest (recursively reverse remaining groups)
        head.next = reverseKGroup(curr, k);

        return prev; // new head of this segment
    }
}
