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
        while(n > 1){
            int idx = 0;
            for(int i = 0; i < n; i += 2){
                ListNode h1 = lists[i];
                ListNode h2 = (i + 1 < n) ? lists[i + 1] : null;
                lists[idx] = merge(h1, h2);
                idx++;
            }
            n = idx;
        }
        return lists[0];
        
    }
}