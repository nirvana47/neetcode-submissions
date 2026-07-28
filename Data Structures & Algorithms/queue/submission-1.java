class Deque {
    private static class Node {
        int val;
        Node next;
        Node prev;

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
        return size == 0;
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

        int value = tail.val;
        tail = tail.prev;
        if (tail == null) // was the last element
            head = null;
        else
            tail.next = null;
        size--;
        return value;
    }

    public int popleft() {
        if (isEmpty()) {
            return -1;
        }
        int value = head.val;
        head = head.next;
        if (head == null) // was the last node
            tail = null;
        else
            head.prev = null;
        size--;
        return value;
    }
}
