package org.example.LL;

public class LC138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        while (curr != null) {
            Node newCurr = new Node(curr.val, curr.next);
            curr.next = newCurr;
            curr = newCurr.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next == null ? null : curr.next.next;
        }

        Node curr_old = head;
        Node newHead = head.next;
        Node newHeadCurr = newHead;
        while (curr_old != null) {
            curr_old.next = curr_old.next.next;
            newHeadCurr.next = newHeadCurr.next != null ? newHeadCurr.next.next : null;
            newHeadCurr = newHeadCurr.next;
            curr_old = curr_old.next;
        }
        return newHead;
    }

    public Node copyRandomListNew(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node new_node = new Node(curr.val, curr.next);
            curr.next = new_node;
            curr = new_node.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next != null ? curr.next.next : null;
        }

        Node new_head = head.next;
        Node curr_old = head;
        Node curr_new = new_head;

        while (curr_old != null) {
            curr_old.next = curr_old.next.next;
            curr_new.next = curr_new.next != null ? curr_new.next.next : null;
            curr_old = curr_old.next;
            curr_new = curr_new.next;
        }

        return new_head;
    }
}
