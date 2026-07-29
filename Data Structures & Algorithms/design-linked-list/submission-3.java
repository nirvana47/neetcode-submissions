class MyLinkedList {
    private static class Node {
        int val;
        Node prev, next;
        Node(int val) { this.val = val; }
    }

    private final Node head; // dummy head
    private final Node tail; // dummy tail
    private int size;

    public MyLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // Returns the node at index, assuming 0 <= index < size.
    private Node nodeAt(int index) {
        Node cur;
        if (index < size / 2) {           // walk forward from head
            cur = head.next;
            for (int i = 0; i < index; i++) cur = cur.next;
        } else {                          // walk backward from tail
            cur = tail.prev;
            for (int i = size - 1; i > index; i--) cur = cur.prev;
        }
        return cur;
    }

    // Insert newNode before the given node.
    private void insertBefore(Node node, int val) {
        Node newNode = new Node(val);
        newNode.prev = node.prev;
        newNode.next = node;
        node.prev.next = newNode;
        node.prev = newNode;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        return nodeAt(index).val;
    }

    public void addAtHead(int val) {
        insertBefore(head.next, val);
    }

    public void addAtTail(int val) {
        insertBefore(tail, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        insertBefore(index == size ? tail : nodeAt(index), val);
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node node = nodeAt(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtdummyHead(val);
 * obj.dummyTddAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */