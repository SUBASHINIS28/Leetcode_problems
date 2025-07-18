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
        ListNode temp=head;
        int c=0;
        while(temp!=null){
            c++;
            temp=temp.next;
        }
        ListNode newhead=null,newtail=null,curr=head;
        while(c>=k){
            ListNode grphead=null,grptail=curr;
            for(int i=0;i<k;i++){
                ListNode next=curr.next;
                curr.next=grphead;
                grphead=curr;
                curr=next;
            }
            if(newhead==null){
                newhead=grphead;
                newtail=grptail;
            }
            else{
                newtail.next=grphead;
                newtail=grptail;
            }
            c=c-k;
        }
        newtail.next=curr;
        return newhead;
    }
}