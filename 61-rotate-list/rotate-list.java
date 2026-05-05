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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            len++;
        }

        k = k%len;
        if(k == 0) return head;

        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        int stps = len-k;
        ListNode curr = head;
        for(int i=1;i<stps;i++){
            curr = curr.next;
        }
        ListNode newhead = curr.next;
        curr.next = null;
        tail.next = head;

        return newhead;
        
    }
}