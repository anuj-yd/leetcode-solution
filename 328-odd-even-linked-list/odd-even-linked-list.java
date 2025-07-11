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
    public ListNode oddEvenList(ListNode head) {
        // 1 base indexing h or first node odd consider kiya gya h
        // ListNode odd = head;
        // ListNode even = head.next;
        // ListNode evenHead = even;

        // while (even != null && even.next != null) {
        //     odd.next = even.next;
        //     odd = odd.next;

        //     even.next = odd.next;
        //     even = even.next;
        // }

        // odd.next = evenHead;
        // return head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);

        ListNode tempo = odd;
        ListNode tempe = even;

        ListNode temp = head;

        while(temp!=null){
            tempo.next = temp;
            temp = temp.next;
            tempo = tempo.next;

            tempe.next = temp;
            if(temp == null) break;
            temp = temp.next;
            tempe = tempe.next;
        }
        
        odd = odd.next;
        even = even.next;
        tempo.next=even;
        return odd;


    }
}
