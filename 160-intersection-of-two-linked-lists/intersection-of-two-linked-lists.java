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
    public int findLen(ListNode temp){
        int len = 0;
         while(temp!=null){

            len +=1;
            temp = temp.next;
        }
        return len;

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null || headB==null){
            return null;
        }

        ListNode temp = headA;
        ListNode temp1 = headB;

        int l1 = findLen(temp);
        int l2 = findLen(temp1);

        int stps = Math.abs(l1-l2);
        
        for(int i=0;i<stps;i++){
            if(l2>l1){
                temp1 = temp1.next;
            }
            if(l1>l2){
                temp = temp.next;
            }
        }
        while(temp!=null){
            if(temp==temp1) return temp;
            temp = temp.next;
            temp1 = temp1.next;
        }
        return null;

       
        
    }
}