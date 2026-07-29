class MyLinkedList {
    private static class Node {
        int val;
        Node prev;
        Node next;

        Node(int value) {
            val = value;
        }
    }

    Node head, tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (size == 0 || index >= size) {
            return -1;
        } else {
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }
    }

    public void addAtHead(int val) {
        Node cur = new Node(val);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            head.prev = cur;
            cur.next = head;
            head = cur;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node cur = new Node(val);
        if (tail == null) {
            tail = cur;
            head = cur;
        } else {
            tail.next = cur;
            cur.prev = tail;
            tail = cur;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        else if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else {
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            } // cur is now at the node, before which we need to add the new node
            Node tempNode = new Node(val);
            tempNode.prev = cur.prev;
            tempNode.next = cur;
            cur.prev.next = tempNode;
            cur.prev = tempNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0)
            return;
        else if (index == 0 && size == 1) {
            head = tail = null;
        } else if (index == 0) {
            head.next.prev = null;
            head = head.next;
        } else if (index == size - 1) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            } // cur is now at the node we need to delete
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            cur.next = null;
            cur.prev = null;
            cur = null;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */