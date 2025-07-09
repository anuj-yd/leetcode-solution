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
    public ListNode reverseList(ListNode head){
        // Using Recursion (this not optimal tc is O(n) and sc is also O(n))

        // if(head==null||head.next == null) return head;
        // ListNode temp = reverseList(head.next);
        // head.next.next = head;
        // head.next = null;
        // return temp;  

        // Optimal is Itrative or 3 pointer approch O(1)  
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
}