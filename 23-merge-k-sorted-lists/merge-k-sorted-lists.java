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
    static class Pair{
        int data;
        ListNode node;
        Pair(int data,ListNode node){
            this.data=data;
            this.node=node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length; 
        if(n == 0) return null;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.data-b.data);
        for(int i=0;i<n;i++){
            if(lists[i]!=null) pq.add(new Pair(lists[i].val,lists[i]));
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ListNode node = p.node;
            temp.next = node;
            if(node.next!=null){
                int d = node.next.val;
                pq.offer(new Pair(d,node.next));
            }
            temp = temp.next;
        }
        return dummy.next;

        
    }
}