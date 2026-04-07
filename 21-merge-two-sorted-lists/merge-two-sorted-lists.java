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
        ListNode f1 = list1;
        ListNode f2 = list2;

        while(f1!=null && f2!=null){
            if(f1.val<f2.val){
                temp.next = f1;
                f1 = f1.next;
            }else if(f1.val>f2.val){
                temp.next = f2;
                f2 = f2.next;
            }else{
                temp.next = f1;
                f1 = f1.next;
            }
            temp = temp.next; 
        }
        while(f1!=null){
            temp.next = f1;
            f1 = f1.next;
            temp = temp.next;
        }
        while(f2!=null){
            temp.next = f2;
            f2 = f2.next;
            temp = temp.next;
        }
        return dummy.next;
        


    }
}