class LinkedList {
    private class Node {
        int val;
        Node next;

        Node() {
            val = -1;
            next = null;
        }

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        // request for invalid index gets a `-1`
        if (index > size)
            return -1;

        // If Linkedlist is empty, then nothing to return
        if (head == null)
            return -1;

        Node cur = head;
        for (int i = 0; i < index; i++) {
            if (cur.next == null)
                return -1;
            cur = cur.next;
        }
        return cur.val;
    }

    public void insertHead(int val) {
        Node cur = new Node(val);
        cur.next = head;
        head = cur;

        // if there is only one node in the LinkedList, and it is
        // the head node, then tail is also the head.
        if (tail == null)
            tail = head;
        
        size++;
    }

    public void insertTail(int val) {
        Node cur = new Node(val);
        size++;

        // what if it is an empty LinkedList at this point?
        if (tail == null) {
            tail = cur;
            head = cur;
            return;
        }

        tail.next = cur;
        tail = cur;
    }

    public boolean remove(int index) {
        // LinkedList is empty
        if (head == null)
            return false;

        // Index is `0` and LinkedList is not empty
        if (index == 0) {
            head = head.next;

            // What if there was only one node in the list?
            if (head == null) {
                tail = null; // Fix the dangling tail
            }
            size--;
            return true;
        }

        Node cur = head;

        // Index is > `0` and LinkedList is not empty
        for (int i = 1; i < index; i++) {
            if (cur.next != null) {
                cur = cur.next;
            } else {
                return false;
            }
        }
        // At this point we should be one node away from the node
        // to be removed from the LinkedList

        // If we are at the tail node?
        // It means invalid input
        if (cur == tail) {
            return false;
        }

        // If we are one node away from tail node?
        // Make `cur` the new tail
        if (cur.next == tail) {
            cur.next = null;
            tail = cur;
            size--;
            return true;
        }

        // If none of the above is true, just regular remove
        cur.next = cur.next.next;
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node cur;
        cur = head;

        while (cur != null) {
            values.add(cur.val);
            cur = cur.next;
        }

        return values;
    }
}