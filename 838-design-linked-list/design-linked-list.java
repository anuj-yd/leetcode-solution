class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {

    Node head;
    Node tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        if (index < 0) return -1;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (temp == null) return -1;
            temp = temp.next;
        }
        return (temp != null) ? temp.data : -1;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null) return;
            temp = temp.next;
        }

        if (temp == null) return;

        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) return;

        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null || temp.next == null) return;
            temp = temp.next;
        }

        if (temp.next == null) return;

        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;
    }
}
