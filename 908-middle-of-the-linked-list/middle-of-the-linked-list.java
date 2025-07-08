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
    // public int size(ListNode head){
    //     ListNode temp = head;
    //     int s = 0;
    //     while(temp!=null){
    //         s++;
    //         temp = temp.next;
    //     }
    //     return s;
    // }
    public ListNode middleNode(ListNode head){
        // int size = size(head);
        // size=size/2;
        // ListNode temp = head;
        // int i=0;
        // while(i<size && temp != null){
        //     temp = temp.next;
        //     i++;
        // }
        // return temp;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}