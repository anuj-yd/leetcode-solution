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
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        head=head.next;
        while(temp!=null && temp.next !=null){
            ListNode prev = temp;
            ListNode nxt = temp.next;
            temp = temp.next.next;
            nxt.next = prev;
            prev.next = (temp!=null && temp.next!=null) ? temp.next : temp;
        }
        return head;
        
    }
}