package org.example.LL;

public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int cunt = 0;
        while (curr != null && cunt != k) {
            curr = curr.next;
            cunt++;
        }
        if (cunt == k) {
            curr = reverseKGroup(curr, k);
            while (cunt-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }
        return head;
    }
}
