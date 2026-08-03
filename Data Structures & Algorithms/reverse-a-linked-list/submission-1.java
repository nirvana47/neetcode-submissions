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
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev, curr, next;
        curr = head;
        prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    //recursive
    // Base Case is empty or 1 node linked-list.
    public ListNode reverseList(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the list starting from the next node
        ListNode newHead = reverseList(head.next);

        // Make the next node point back to current node
        head.next.next = head;

        // Break the old forward link
        head.next = null;

        return newHead;
    }
}
