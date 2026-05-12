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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2==null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){

            int sum = carry;

            if(l1!=null) sum+=l1.val;
            if(l2!=null) sum+=l2.val;

            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            temp.next = newNode;
            temp = temp.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        return dummy.next;
        
    }
}