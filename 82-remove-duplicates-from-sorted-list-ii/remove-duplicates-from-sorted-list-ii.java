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
    public ListNode deleteDuplicates(ListNode head){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy; 

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null){
            while(fast!=null && slow.val == fast.val){
                fast = fast.next;
            }
            if(slow.next==fast){
                temp.next = slow;
                temp = temp.next;
                temp.next=null;
            }
            slow = fast;
        }
        return dummy.next;
        
    }
}