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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode temp = head;
        while(temp!=null){
            pq.add(temp.val);
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode dm = dummy;
        while(!pq.isEmpty()){
            int data = pq.poll();
            dm.next = new ListNode(data);
            dm = dm.next;
        }
        return dummy.next;
    }
}