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
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        // pq.add(head);
        ListNode temp = head;
        while(temp!=null){
            pq.add(temp);
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode dm = dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            dm.next = node;
            dm = dm.next;
        }
        dm.next = null;
        return dummy.next;
    }
}