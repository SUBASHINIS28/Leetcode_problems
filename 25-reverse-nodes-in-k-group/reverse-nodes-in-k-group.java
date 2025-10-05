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
        // write your code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 0;
        ListNode pivot = head;
        while (count < k && pivot != null) {
            pivot = pivot.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        dummy.next = reverse(head, k);
        head.next = reverseKGroup(pivot, k);
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        int i = 0;
        while (head != null && i < k) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
            i++;
        }
        return prev;
    }

}