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
    public ListNode reverse(ListNode node){
        ListNode temp = node;
        ListNode prev = null;
        while(temp!=null){
            ListNode nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        }
        return prev;
        
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newNode = reverse(slow);
        ListNode temp = newNode;
        ListNode temp1 = head;

        while(temp!=null){
            if(temp.val!=temp1.val){
                reverse(newNode);
                return false;
            }
            temp = temp.next;
            temp1 = temp1.next;
        }
        reverse(newNode);
        return true;

        
    }
}