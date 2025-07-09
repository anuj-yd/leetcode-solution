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
        // WITHOUT USING EXTRA SPACES;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode h = new ListNode(0);
        ListNode temp = h;

        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }
        if(temp1 == null){
            temp.next = temp2;
        }else{
            temp.next = temp1;
        }
        return h.next;
    }


    //     ListNode temp1 = list1;
    //     ListNode temp2 = list2;

    //     ListNode head = new ListNode(0); // Dummy node
    //     ListNode temp = head;

    //     while (temp1 != null && temp2 != null) {
    //         if (temp1.val < temp2.val) {
    //             temp.next = new ListNode(temp1.val);
    //             temp1 = temp1.next;
    //         } else {
    //             temp.next = new ListNode(temp2.val);
    //             temp2 = temp2.next;
    //         }
    //         temp = temp.next;
    //     }

    //     if (temp1 != null) {
    //         temp.next = temp1;
    //     } else {
    //         temp.next = temp2;
    //     }

    //     return head.next;
    // }
}
