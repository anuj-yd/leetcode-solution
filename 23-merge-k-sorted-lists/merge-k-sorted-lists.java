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
    public ListNode merge(ListNode list1,ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else if(l2.val<l1.val){
                temp.next = l2;
                l2 = l2.next;
            }else{
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }

        while(l1!=null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2!=null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    public ListNode partisanAndMerge(int s,int e,ListNode[] list){
        if(s>e) return null;
        if(s==e){
            return list[s];
        }
        int mid = s+(e-s)/2;
        ListNode l1 = partisanAndMerge(s,mid,list);
        ListNode l2 = partisanAndMerge(mid+1,e,list);
        return merge(l1,l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n==0) return null;
        return partisanAndMerge(0,n-1,lists);
    }
}