/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int s1 = size(headA);
        int s2 = size(headB);

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        if(s1>s2){
            int p = s1-s2;
            for(int i=0;i<p;i++){
                temp1 = temp1.next;
            }
        }else{
            int q = s2-s1;
            for(int i=0;i<q;i++){
                temp2 = temp2.next;
            }
        }

        while(temp1!=temp2 && temp1!=null && temp2!=null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }

    public int size(ListNode h){
        ListNode temp = h;
        int size = 0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
}