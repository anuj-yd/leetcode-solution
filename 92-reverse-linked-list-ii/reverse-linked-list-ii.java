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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i=1;i<left;i++){
            prev = prev.next;
        }

        ListNode temp = prev.next;
        ListNode t1 = prev;
        ListNode t2 = prev.next;

        for(int i = 0 ; i<right-left+1;i++){

            ListNode nxt = temp.next;
            temp.next = prev;
            prev = temp; 
            temp = nxt;

        }
        t1.next = prev;
        t2.next = temp;
        return dummy.next;

        
    }
}