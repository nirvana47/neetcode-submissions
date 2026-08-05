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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int amount = lists.length;
        while (amount > 1) {
            for (int i = 0; i < amount; i += 2) {
                if (i + 1 < amount) {
                    lists[i / 2] = mergeTwoLists(lists[i], lists[i + 1]);
                } else {
                    lists[i / 2] = lists[i];
                }
            }
            amount = (amount + 1) / 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead; // we will grow the tail, and keep the dummy

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }

        return dummyHead.next; // this is the dummy head node
    }
}
