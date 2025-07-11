/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node h = new Node(0);
        Node temp2 = h;
        Node temp1 = head;
        while(temp1!=null){
            Node t = new Node(temp1.val);
            temp2.next = t;
            temp2 = t;
            temp1 = temp1.next;
        }
        h = h.next;
        temp2 = h;
        temp1 = head;

        Node temp = new Node(0);
        while(temp1!=null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp=temp.next;

            temp.next = temp2;
            temp2 = temp2.next;
            if(temp!=null)temp = temp.next;
        }
        temp2 = h;
        temp1 = head;

        while (temp1 != null) {
            if (temp1.random == null) {
                temp1.next.random = null;
            } else {
                temp1.next.random = temp1.random.next;
            }
            temp1 = temp1.next.next;
        }

        temp2 = h;
        temp1 = head;

        while(temp1!=null){
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if(temp1==null) break;

            temp2.next = temp1.next;
            if(temp2.next==null) break;
            temp2 = temp2.next;
        }
        return h;









    }
}