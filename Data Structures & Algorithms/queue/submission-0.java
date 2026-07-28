class Deque {
    private class Node {
        int val;
        Node next;
        Node prev;

        public Node() {
            next = null;
            prev = null;
        }

        public Node(int val) {
            this.val = val;
            next = null;
            prev = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void append(int value) {
        Node cur = new Node(value);

        // if this is the 1st node being added then head and tail are same
        if (isEmpty()) {
            tail = cur;
            head = cur;
        } else {
            tail.next = cur;
            cur.prev = tail;
            cur.next = null;
            tail = cur;
        }

        size++;
    }

    public void appendleft(int value) {
        Node cur = new Node(value);

        // if this is the 1st element being added, head and tail are the same
        if (isEmpty()) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.prev = cur;
            cur.prev = null;
            head = cur;
        }

        size++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        // if there is only 1 element in the DQ
        else if (size == 1) {
            int value = head.val;
            head = null;
            tail = null;
            size--;
            return value;
        } else {
            int value = tail.val; // get the current tail value
            Node cur = tail; // create a pointer to the tail
            cur = cur.prev; // Move pointer one node previous
            cur.next = null; // since cur is the new tail, next is point to null
            tail = cur; // `tail` is now where the pointer is
            size--;
            return value;
        }
    }

    public int popleft() {
        if (isEmpty()) {
            return -1;
        }
        // if there is only 1 element in the DQ
        else if (size == 1) {
            int value = head.val;
            head = null;
            tail = null;
            size--;
            return value;
        } else {
            int value = head.val; // get current head value
            Node cur = head; // new pointer, point it at head
            cur = cur.next; // shift pointer to node after head
            cur.prev = null; // cur is the new temporary head, so prev is pointing to null
            head = cur; // make cur the new head
            size --;
            return value;
        }
    }
}
