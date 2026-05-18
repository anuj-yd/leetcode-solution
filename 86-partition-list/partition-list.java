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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode ls = less;
        ListNode greater = new ListNode(0);
        ListNode gt = greater;


        ListNode temp = head;
        while(temp!=null){
            if(temp.val<x){
                ls.next = new ListNode(temp.val);
                ls = ls.next;
            }else{
                gt.next = new ListNode(temp.val);
                gt = gt.next;
            }
            temp = temp.next;
        }
        ls.next = greater.next;

        return less.next;
        
    }
}