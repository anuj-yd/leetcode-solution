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
        ListNode curr = head;
        ListNode temp = null;
        ListNode prev = null;

        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverse(slow.next);

        int max=0;
        ListNode t1 = head; 
        ListNode t2 = slow.next;
        while(t2!=null){
            int sum = t1.val + t2.val;
            max = Math.max(sum,max);
            t1= t1.next;
            t2= t2.next;
        } 
        return max;
        
    }
}