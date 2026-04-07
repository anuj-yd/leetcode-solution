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
    public ListNode reverse(ListNode head,ListNode tail){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=tail){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode tail = head;
        for(int i=0;i<k;i++){
            if(tail==null) return head;
            tail = tail.next;
        }

        ListNode newHead = reverse(head,tail);
        head.next = reverseKGroup(tail,k);
        return newHead;
    }
}