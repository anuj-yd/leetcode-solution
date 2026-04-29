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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else if(l1.val>l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else{
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next; 
        }
        while(l1!=null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2!=null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return dummy.next;
        


    }
}