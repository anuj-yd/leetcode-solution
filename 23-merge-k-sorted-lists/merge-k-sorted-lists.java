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
    public ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode dm = dummy;

        ListNode t1 = l1;
        ListNode t2 = l2;

        while(t1!=null && t2!=null){
            if(t1.val<=t2.val){
                dm.next = t1;
                t1 = t1.next;
            }else{
                dm.next = t2;
                t2=t2.next;
            }
            dm = dm.next;
        }
        if(t1!=null) dm.next = t1;
        if(t2!=null) dm.next = t2;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if(n == 0) return null;

        ListNode h1 = lists[0];

        for(int i = 1; i < n; i++){

            h1 = merge(h1, lists[i]);
        }
        return h1;
        
    }
}