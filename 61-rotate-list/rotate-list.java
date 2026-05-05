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
    
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        int n=1;
        if(head==null) return null;
        
        while(temp.next!=null){
            temp=temp.next;
            n++;
        }
        k=k%n;
        temp.next=head;
        temp=head;
        for(int i=0;i<n-k-1;i++){
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
        return head;
    }
}