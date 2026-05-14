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
    public ListNode reverse(ListNode head){
        ListNode temp =head;
        ListNode prev = null;

        while(temp!=null){
            ListNode nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode dm = dummy;
        ListNode start = head;
        ListNode end = head;
        while(end!=null){
            for(int i=0;i<k-1;i++){
                if(end==null|| end.next==null){
                    dm.next = start;
                    return dummy.next;
                }
                end = end.next;
            }
            ListNode temp = end.next;
            end.next = null;
            dm.next = reverse(start);
            dm = start;
            start = temp;
            end = temp;
        }
        return dummy.next;
    }
}